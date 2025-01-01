package profolio.server.domain.rds.user.enumeration

enum class JwtType(
    val value: String
) {
    ACCESS("access"),
    REFRESH("refresh")
}