package profolio.server.common.exception.global

import profolio.server.common.exception.status.StatusCode

enum class GlobalExceptionCode(
    override val status: Int,
    override val message: String
): StatusCode {
    INTERNAL_SERVER(500, "서버 오류");

    fun getName(): String = this.name
}