package profolio.server.infrastructure.security.jwt.support

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import profolio.server.domain.rds.user.entity.UserDetails
import profolio.server.domain.rds.user.entity.UserEntity

@Component
object UserAuthenticationHolder {
    fun current(): UserEntity {
        return (SecurityContextHolder.getContext().authentication.principal as UserDetails).user
    }
}