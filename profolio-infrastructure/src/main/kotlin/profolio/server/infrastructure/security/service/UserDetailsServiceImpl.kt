package profolio.server.infrastructure.security.service

import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import profolio.server.domain.rds.user.entity.UserDetails
import profolio.server.domain.rds.user.repository.UserRepository

@Service
class UserDetailsServiceImpl(
    val userRepository: UserRepository
): UserDetailsService {
    override fun loadUserByUsername(email: String): UserDetails {
        return userRepository.findByEmail(email)?.let { UserDetails(it) }
            ?: throw UsernameNotFoundException("찾을 수 없음")
    }
}