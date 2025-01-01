package profolio.server.domain.rds.user.exception

import profolio.server.common.exception.CustomException

class UserNotFoundException: CustomException(UserExceptionCode.USER_NOT_FOUND)