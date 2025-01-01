package profolio.server.restapi.auth.application.data.request

data class RegisterRequest(
    val email: String,
    val password: String,
    val passwordCheck: String,
    val nickname: String? = null,
    val profileImage: String? = null
)
