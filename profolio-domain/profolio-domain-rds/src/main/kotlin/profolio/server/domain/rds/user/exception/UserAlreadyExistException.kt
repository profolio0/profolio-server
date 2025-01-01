package profolio.server.domain.rds.user.exception

import profolio.server.common.exception.CustomException

class UserAlreadyExistException: CustomException(UserExceptionCode.USER_ALREADY_EXISTS)