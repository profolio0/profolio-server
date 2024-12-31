package profolio.server.infrastructure.security.jwt.util

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "app.jwt")
data class JwtProvider (
    val secretKey: String,
    val access: Long,
    val refresh: Long
)