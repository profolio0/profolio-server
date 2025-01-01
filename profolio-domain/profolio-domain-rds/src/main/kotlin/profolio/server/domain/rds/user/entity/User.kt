package profolio.server.domain.rds.user.entity

data class User(
    val id: UserId = UserId(0L),
    val email: String,
    val password: String,
    val nickname: String?,
    val profileImage: String?,
    val role: String
)

@JvmInline
value class UserId(val value: Long)