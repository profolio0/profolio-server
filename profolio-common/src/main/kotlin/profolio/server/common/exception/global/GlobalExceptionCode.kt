package profolio.server.common.exception.global

import profolio.server.common.exception.status.StatusCode

enum class GlobalExceptionCode(
    override val status: Int,
    override val message: String
): StatusCode {
    BAD_JSON(400, "잘못된 JSON 형식"),
    NOT_FOUND(404, "존재하지 않는 endpoint"),
    INTERNAL_SERVER(500, "서버 오류");

    fun getName(): String = this.name
}