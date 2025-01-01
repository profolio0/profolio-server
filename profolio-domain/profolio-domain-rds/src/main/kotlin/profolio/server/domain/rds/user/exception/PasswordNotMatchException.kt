package profolio.server.domain.rds.user.exception

import profolio.server.common.exception.CustomException

class PasswordNotMatchException: CustomException(UserExceptionCode.PASSWORD_NOT_MATCH)