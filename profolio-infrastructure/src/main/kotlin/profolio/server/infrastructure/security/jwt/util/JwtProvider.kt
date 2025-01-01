package profolio.server.infrastructure.security.jwt.util

import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Component
import profolio.server.domain.rds.user.entity.User
import profolio.server.domain.rds.user.enumeration.JwtType
import profolio.server.infrastructure.security.jwt.properties.JwtProperties

@Component
class JwtProvider(
    private val jwtProperties: JwtProperties
) {

    fun getId(token: String): Long {
        return Jwts.parser().verifyWith(jwtProperties.secretKeySpec).build().parseSignedClaims(token).payload.id.toLong()
    }

    fun generate(user: User, tokenType: JwtType, expire: Long): String {
        return Jwts.builder()
            .id(user.id.toString())
            .claim("category", tokenType.value)
            .claim("email", user.email)
            .claim("role", user.role)
            .signWith(jwtProperties.secretKeySpec)
            .compact()
    }
}