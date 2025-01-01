package profolio.server.restapi.auth.presentation

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import profolio.server.restapi.auth.application.data.request.LoginRequest
import profolio.server.restapi.auth.application.data.request.RegisterRequest
import profolio.server.restapi.support.data.Response
import profolio.server.restapi.support.data.ResponseData

@RestController
@RequestMapping("/auth")
class AuthController(
) {
    @PostMapping("/sign-in")
    fun signIn(
        @RequestBody loginRequest: LoginRequest
    ): Response {
        TODO("로그인")
    }

    @PostMapping("/sign-up")
    fun signUp(
        @RequestBody registerRequest: RegisterRequest
    ): Response {
        TODO("회원가입")
    }
}