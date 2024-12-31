package profolio.server.domain.rds.user.entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetails(
    var user: User
): UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority> {
        return listOf(GrantedAuthority { user.role })
    }

    override fun getPassword(): String = user.password

    override fun getUsername(): String = user.email

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}