package profolio.server.infrastructure.security.jwt.util

import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Component
import profolio.server.common.exception.global.jwt.ExpiredTokenException
import profolio.server.common.exception.global.jwt.InvalidSignatureException
import profolio.server.common.exception.global.jwt.InvalidTokenException
import profolio.server.domain.rds.user.entity.User
import profolio.server.domain.rds.user.enumeration.JwtType
import profolio.server.infrastructure.security.jwt.properties.JwtProperties
import java.lang.System.currentTimeMillis
import java.util.*

@Component
class JwtProvider(
    private val jwtProperties: JwtProperties
) {
    fun getId(token: String): Long {
        return Jwts.parser().verifyWith(jwtProperties.secretKeySpec).build().parseSignedClaims(token).payload
            .id.toLong()
    }

    fun getToken(token: String): String {
        return Jwts.parser().verifyWith(jwtProperties.secretKeySpec).build().parseSignedClaims(token).payload["category"].toString()
    }

    fun validateAll(token: String, tokenType: JwtType) {
        validate(token)
        validateType(token, tokenType)
    }

    fun validateType(token: String, tokenType: JwtType) {
        if (getToken(token) != tokenType.value) throw InvalidTokenException()
    }

    fun validate(token: String) {
        try {
            getToken(token)
            if (
                Jwts.parser()
                    .verifyWith(jwtProperties.secretKeySpec)
                    .build()
                    .parseSignedClaims(token)
                    .payload.expiration.before(Date())
            ) throw ExpiredTokenException()
        } catch (e: io.jsonwebtoken.ExpiredJwtException) {
            throw ExpiredTokenException()
        } catch (e: io.jsonwebtoken.security.SignatureException) {
            throw InvalidSignatureException()
        } catch (e: Exception) {
            throw InvalidTokenException()
        }
    }

    fun generate(user: User, tokenType: JwtType, expire: Long): String {
        return Jwts.builder()
            .id(user.id.value.toString())
            .claim("category", tokenType.value)
            .claim("email", user.email)
            .claim("role", user.role)
            .issuedAt(Date(currentTimeMillis()))
            .expiration(Date(currentTimeMillis() + expire))
            .signWith(jwtProperties.secretKeySpec)
            .compact()
    }
}