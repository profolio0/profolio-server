package profolio.server.common.exception.global

import profolio.server.common.exception.CustomException

class InternalServerException: CustomException(GlobalExceptionCode.INTERNAL_SERVER)