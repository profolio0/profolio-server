package profolio.server.infrastructure.security.jwt.util

import org.springframework.boot.context.properties.ConfigurationProperties
import java.nio.charset.StandardCharsets
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

@ConfigurationProperties(prefix = "app.jwt")
data class JwtProperties (
    private val secretKey: String,
    val access: Long,
    val refresh: Long
) {
    val secretKeySpec: SecretKey
        get() = SecretKeySpec(secretKey.toByteArray(StandardCharsets.UTF_8), "HmacSHA256")
}