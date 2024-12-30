package profolio.server.infrastructure.security.jwt.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import profolio.server.infrastructure.security.jwt.support.TokenExtractor
import profolio.server.domain.rds.user.enumeration.TokenType

@Component
class TokenFilter: OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token: String = TokenExtractor.extract(request, TokenType.BEARER)

        if (token.isNotEmpty()) {

        }
    }
}