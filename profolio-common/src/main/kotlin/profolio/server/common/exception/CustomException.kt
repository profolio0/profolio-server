package profolio.server.common.exception

import profolio.server.common.exception.status.StatusCode

open class CustomException(
    val exceptionCode: StatusCode
): RuntimeException()