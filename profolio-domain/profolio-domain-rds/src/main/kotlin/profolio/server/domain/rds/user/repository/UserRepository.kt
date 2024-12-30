package profolio.server.domain.rds.user.repository

import org.springframework.data.jpa.repository.JpaRepository
import profolio.server.domain.rds.user.entity.UserEntity

interface UserRepository: JpaRepository<UserEntity, Long> {
    fun findOneById(id: Long): UserEntity?
}