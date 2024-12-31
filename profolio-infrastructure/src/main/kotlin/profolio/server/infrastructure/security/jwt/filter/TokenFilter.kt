package profolio.server.infrastructure.security.jwt.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import profolio.server.domain.rds.user.entity.UserDetails
import profolio.server.domain.rds.user.entity.UserId
import profolio.server.infrastructure.security.jwt.support.TokenExtractor
import profolio.server.domain.rds.user.enumeration.TokenType
import profolio.server.domain.rds.user.repository.UserRepository

@Component
class TokenFilter(
    val userRepository: UserRepository
): OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token: String = TokenExtractor.extract(request, TokenType.BEARER)
        if (token.isNotEmpty()) {
            setAuthentication(token)
        }
        filterChain.doFilter(request, response)
    }

    private fun setAuthentication(token: String) {
        SecurityContextHolder.getContext().authentication = createAuthentication(token)
    }

    private fun createAuthentication(token: String): UsernamePasswordAuthenticationToken {
        val userDetails: UserDetails = getUserDetails(token)
        return UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
    }

    private fun getUserDetails(token: String): UserDetails {
        return UserDetails(user = userRepository.findById(UserId(token.)))
    }

}