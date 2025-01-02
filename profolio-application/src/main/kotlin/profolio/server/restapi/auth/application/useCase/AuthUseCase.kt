package profolio.server.restapi.auth.application.useCase

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component
import profolio.server.domain.rds.user.entity.User
import profolio.server.domain.rds.user.entity.UserId
import profolio.server.domain.rds.user.enumeration.JwtType
import profolio.server.domain.rds.user.enumeration.TokenType
import profolio.server.domain.rds.user.exception.PasswordNotMatchException
import profolio.server.domain.rds.user.exception.UserAlreadyExistException
import profolio.server.domain.rds.user.exception.UserNotFoundException
import profolio.server.domain.rds.user.repository.UserRepository
import profolio.server.infrastructure.security.jwt.properties.JwtProperties
import profolio.server.infrastructure.security.jwt.util.JwtProvider
import profolio.server.restapi.auth.application.data.request.LoginRequest
import profolio.server.restapi.auth.application.data.request.RegisterRequest
import profolio.server.restapi.auth.application.data.request.ReissueRequest
import profolio.server.restapi.auth.application.data.response.TokenResponse
import profolio.server.restapi.support.data.Response
import profolio.server.restapi.support.data.ResponseData

@Component
class AuthUseCase(
    private val userRepository: UserRepository,
    private val encoder: BCryptPasswordEncoder,
    private val jwtProvider: JwtProvider,
    private val jwtProperties: JwtProperties
) {
    fun login(loginRequest: LoginRequest): ResponseData<TokenResponse> {
        val user: User = userRepository.findByEmail(loginRequest.email)?: throw UserNotFoundException()
        checkPassword(loginRequest.password, user.password)

        return ResponseData.ok(generateTokens(user))
    }

    fun register(registerRequest: RegisterRequest): Response {
        checkIdDuplicate(registerRequest)
        checkPassword(registerRequest)
        userRepository.save(registerRequest.toUser(encoder.encode(registerRequest.password)))

        return Response.created("successFully registered")
    }

    fun reissue(reissueRequest: ReissueRequest): ResponseData<TokenResponse> {
        jwtProvider.validate(reissueRequest.refresh, JwtType.REFRESH)
        return ResponseData.created(
            generateTokens(
                userRepository.findById(UserId(jwtProvider.getId(reissueRequest.refresh)))
                    ?: throw UserNotFoundException()
            )
        )
    }

    private fun generateTokens(user: User): TokenResponse {
        return TokenResponse(
            jwtProvider.generate(user, JwtType.ACCESS, jwtProperties.access),
            jwtProvider.generate(user, JwtType.REFRESH, jwtProperties.refresh)
        )
    }

    private fun checkPassword(registerRequest: String, encodedPassword: String) {
        if (!encoder.matches(registerRequest, encodedPassword)) throw PasswordNotMatchException()
    }

    private fun checkPassword(registerRequest: RegisterRequest) {
        if (registerRequest.password != registerRequest.passwordCheck) throw PasswordNotMatchException()
    }

    private fun checkIdDuplicate(registerRequest: RegisterRequest) {
        print(userRepository.findByEmail(registerRequest.email))
        userRepository.findByEmail(registerRequest.email)?.let { throw UserAlreadyExistException() }
    }
}