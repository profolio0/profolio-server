package profolio.server.domain.rds.user.repository

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.selectAll
import org.springframework.stereotype.Repository
import profolio.server.domain.rds.user.entity.UserEntity
import profolio.server.domain.rds.user.entity.UserId
import profolio.server.domain.rds.user.entity.User

@Repository
class UserRepository {
    fun findById(id: UserId): User? {
        return UserEntity
            .selectAll()
            .where { UserEntity.id eq id.value }
            .firstOrNull()
            ?.toUser()
    }

    fun findByEmail(email: String): User? {
        return UserEntity
            .selectAll()
            .where { UserEntity.email eq email }
            .firstOrNull()
            ?.toUser()
    }

    fun save(user: User) {
        UserEntity.insertAndGetId {
            it[email] = user.email
            it[password] = user.password
            it[nickname] = user.nickname
            it[profileImage] = user.profileImage
            it[role] = user.role
        }
    }

    private fun ResultRow.toUser(): User {
        return User(
            id = UserId(this[UserEntity.id].value),
            email = this[UserEntity.email],
            password = this[UserEntity.password],
            nickname = this[UserEntity.nickname],
            profileImage = this[UserEntity.profileImage],
            role = this[UserEntity.role]
        )
    }
}