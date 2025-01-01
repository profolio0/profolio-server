package profolio.server.domain.rds.user.exception

import profolio.server.common.exception.status.StatusCode

enum class UserExceptionCode(
    override val status: Int,
    override val message: String
): StatusCode {
    USER_ALREADY_EXISTS(400, "User already exists"),
    USER_NOT_FOUND(404, "User not found"),
    USER_NOT_AUTHORIZED(403, "User not authorized");
}