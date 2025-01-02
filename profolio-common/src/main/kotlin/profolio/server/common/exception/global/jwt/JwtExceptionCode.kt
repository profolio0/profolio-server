package profolio.server.common.exception.global.jwt

import profolio.server.common.exception.status.StatusCode

enum class JwtExceptionCode(
    override val status: Int,
    override val message: String
): StatusCode {
    INVALID_TOKEN(401, "Invalid token"),
    EXPIRED_TOKEN(401, "Expired token"),
    INVALID_SIGNATURE(402, "Invalid signature");
}