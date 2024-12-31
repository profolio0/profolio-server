package profolio.server.infrastructure.security.jwt.support

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import profolio.server.domain.rds.user.entity.User
import profolio.server.domain.rds.user.entity.UserDetails

@Component
object UserAuthenticationHolder {
    fun current(): User {
        return (SecurityContextHolder.getContext().authentication.principal as UserDetails).user
    }
}