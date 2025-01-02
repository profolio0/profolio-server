package profolio.server.restapi.auth.presentation

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import profolio.server.restapi.auth.application.data.request.LoginRequest
import profolio.server.restapi.auth.application.data.request.ReissueRequest
import profolio.server.restapi.auth.application.data.request.RegisterRequest
import profolio.server.restapi.auth.application.data.response.TokenResponse
import profolio.server.restapi.auth.application.useCase.AuthUseCase
import profolio.server.restapi.support.data.Response
import profolio.server.restapi.support.data.ResponseData

@RestController
@RequestMapping("/auth")
class AuthController(
    private val useCase: AuthUseCase
) {
    @PostMapping("/sign-in")
    fun signIn(
        @RequestBody loginRequest: LoginRequest
    ): ResponseData<TokenResponse> {
        return useCase.login(loginRequest)
    }

    @PostMapping("/sign-up")
    fun signUp(
        @RequestBody registerRequest: RegisterRequest
    ): Response {
        return useCase.register(registerRequest)
    }

    @PostMapping("/reissue")
    fun reissue(
        @RequestBody reissueRequest: ReissueRequest
    ): ResponseData<TokenResponse> {
        TODO()
    }
}