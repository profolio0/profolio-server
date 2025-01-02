package profolio.server.common.exception.global.jwt

import profolio.server.common.exception.CustomException

class ExpiredTokenException: CustomException(JwtExceptionCode.EXPIRED_TOKEN)
class InvalidTokenException: CustomException(JwtExceptionCode.INVALID_TOKEN)
class InvalidSignatureException: CustomException(JwtExceptionCode.INVALID_SIGNATURE)