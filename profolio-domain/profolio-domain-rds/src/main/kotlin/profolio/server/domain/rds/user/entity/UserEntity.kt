package profolio.server.domain.rds.user.entity

import org.jetbrains.exposed.dao.id.LongIdTable

object UserEntity: LongIdTable() {
    val email = varchar("email", 255)
    val nickname = text("nickname").nullable()
    val password = varchar("password", 255)
    val profileImage = text("profile_image").default("https://picsum.photos/200")
    val role = varchar("role", 50)
}