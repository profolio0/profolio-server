package profolio.server.domain.rds.user.entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import profolio.server.domain.rds.user.repository.UserRepository

class UserDetails(
    var user: UserEntity,
    private val userRepository: UserRepository
): UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority> {
        return listOf(GrantedAuthority { user.role.value })
    }

    override fun getPassword(): String = user.password

    override fun getUsername(): String = user.email

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true

    fun setUser(id: Long) {
        user = userRepository.findOneById(id) ?: throw RuntimeException("User not found")
    }
}