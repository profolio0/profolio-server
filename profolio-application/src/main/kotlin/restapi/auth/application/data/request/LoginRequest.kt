package restapi.auth.application.data.request

data class LoginRequest(
    val email: String,
    val password: String
)