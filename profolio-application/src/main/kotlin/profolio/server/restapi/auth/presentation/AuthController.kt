package profolio.server.restapi.auth.presentation

import profolio.server.restapi.auth.application.data.request.LoginRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import profolio.server.restapi.support.data.Response

@RestController
@RequestMapping("/auth")
class AuthController(
) {
    @GetMapping("/sign-in")
    fun signIn(
        @RequestBody loginRequest: LoginRequest
    ): ResponseEntity<Response<Any>>? {
        return
    }
}