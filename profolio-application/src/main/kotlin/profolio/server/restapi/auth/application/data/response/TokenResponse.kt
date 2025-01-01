package profolio.server.restapi.auth.application.data.response

data class TokenResponse(
    val access: String,
    val refresh: String
)