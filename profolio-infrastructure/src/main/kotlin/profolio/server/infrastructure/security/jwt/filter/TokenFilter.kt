package profolio.server.infrastructure.security.jwt.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import profolio.server.domain.rds.user.entity.User
import profolio.server.domain.rds.user.entity.UserDetails
import profolio.server.domain.rds.user.entity.UserId
import profolio.server.domain.rds.user.enumeration.TokenType
import profolio.server.domain.rds.user.repository.UserRepository
import profolio.server.infrastructure.security.jwt.util.TokenExtractor
import profolio.server.infrastructure.security.jwt.util.JwtProvider

@Component
class TokenFilter(
    private val userRepository: UserRepository,
    private val jwtProvider: JwtProvider
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
        jwtProvider.validate(token)
        SecurityContextHolder.getContext().authentication = createAuthentication(token)
    }

    private fun createAuthentication(token: String): UsernamePasswordAuthenticationToken {
        val userDetails: UserDetails = getUserDetails(token)
        return UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
    }

    private fun getUserDetails(token: String): UserDetails {
        val user: User = userRepository.findById(UserId(jwtProvider.getId(token)))?: throw RuntimeException("User not found")
        return UserDetails(user)
    }
}