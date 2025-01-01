package profolio.server.restapi.auth.application.data.request

import profolio.server.domain.rds.user.entity.User
import profolio.server.domain.rds.user.enumeration.UserRole

data class RegisterRequest(
    val email: String,
    val password: String,
    val passwordCheck: String,
    val nickname: String? = null,
    val profileImage: String? = null
) {
    fun toUser(encodedPassword: String): User {
        return User(
            email = this.email,
            password = encodedPassword,
            nickname = this.nickname,
            profileImage = this.profileImage,
            role = UserRole.USER.name
        )
    }
}