package profolio.server.domain.rds.user.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.Email
import profolio.server.domain.rds.user.enumeration.UserRole

@Entity(name = "user_tbl")
open class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Email
    val email: String,
    val password: String,
    val role: UserRole
)