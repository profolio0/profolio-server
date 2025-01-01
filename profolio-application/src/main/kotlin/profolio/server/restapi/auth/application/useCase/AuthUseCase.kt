package profolio.server.restapi.auth.application.useCase

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component
import profolio.server.domain.rds.user.exception.PasswordNotMatchException
import profolio.server.domain.rds.user.exception.UserAlreadyExistException
import profolio.server.domain.rds.user.repository.UserRepository
import profolio.server.restapi.auth.application.data.request.RegisterRequest
import profolio.server.restapi.support.data.Response

@Component
class AuthUseCase(
    private val userRepository: UserRepository,
    private val encoder: BCryptPasswordEncoder
) {
    fun register(registerRequest: RegisterRequest): Response {
        checkIdDuplicate(registerRequest)
        checkPassword(registerRequest)
        userRepository.save(registerRequest.toUser(encoder.encode(registerRequest.password)))

        return Response.ok("successFully registered")
    }

    private fun checkPassword(registerRequest: RegisterRequest) {
        if (registerRequest.password != registerRequest.passwordCheck) throw PasswordNotMatchException()
    }

    private fun checkIdDuplicate(registerRequest: RegisterRequest) {
        print(userRepository.findByEmail(registerRequest.email))
        userRepository.findByEmail(registerRequest.email)?.let { throw UserAlreadyExistException() }
    }
}