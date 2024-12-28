package security.jwt.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "app.jwt")
class JwtProperties {
    val secret: String = ""
}