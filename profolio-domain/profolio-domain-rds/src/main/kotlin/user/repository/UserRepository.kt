package user.repository

import org.springframework.data.jpa.repository.JpaRepository
import user.entity.UserEntity

interface UserRepository: JpaRepository<UserEntity, Long> {
    fun findOneById(id: Long): UserEntity?
}