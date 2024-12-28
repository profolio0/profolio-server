package security.jwt.support

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import user.entity.UserDetails
import user.entity.UserEntity

@Component
object UserAuthenticationHolder {
    fun current(): UserEntity {
        return (SecurityContextHolder.getContext().authentication.principal as UserDetails).user
    }
}