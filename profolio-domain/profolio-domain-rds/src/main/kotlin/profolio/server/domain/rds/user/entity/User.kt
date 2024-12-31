package profolio.server.domain.rds.user.entity

import org.apache.logging.log4j.util.StringMap

data class User(
    val id: UserId,
    val email: String,
    val password: String,
    val nickname: String?,
    val profileImage: String,
    val role: String
)

@JvmInline
value class UserId(val value: Long)