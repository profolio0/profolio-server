package auth.application.data.response

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String
)