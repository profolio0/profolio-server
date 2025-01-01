package profolio.server.restapi.auth.application.useCase

import org.springframework.stereotype.Component
import profolio.server.domain.rds.user.exception.UserAlreadyExistException
import profolio.server.domain.rds.user.repository.UserRepository
import profolio.server.restapi.auth.application.data.request.RegisterRequest

@Component
class AuthUseCase(
    val userRepository: UserRepository
) {
    fun register(registerRequest: RegisterRequest) {
        userRepository.findByEmail(registerRequest.email)?: throw UserAlreadyExistException()

        if (registerRequest.password != registerRequest.passwordCheck) {
//            throw
        }
    }
}