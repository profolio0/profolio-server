package profolio.server.infrastructure.security.jwt.util

import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Component

@Component
class JwtProvider(
    val jwtProperties: JwtProperties
) {

    fun getId(token: String): Long {
        return Jwts.parser().verifyWith(jwtProperties.secretKeySpec).build().parseSignedClaims(token).payload.id.toLong()
    }

    fun generate(): String {
        return Jwts.builder()
            .id(UUID.randomUUID().toString())
            .signWith(jwtProperties.secretKeySpec)
            .compact()
    }
}