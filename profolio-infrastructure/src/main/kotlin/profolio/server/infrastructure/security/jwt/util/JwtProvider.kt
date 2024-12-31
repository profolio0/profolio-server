package profolio.server.infrastructure.security.jwt.util

import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Component

@Component
class JwtProvider {

    fun generate(): String? {
        return Jwts.builder()
            .claim()
            .compact()
    }
}