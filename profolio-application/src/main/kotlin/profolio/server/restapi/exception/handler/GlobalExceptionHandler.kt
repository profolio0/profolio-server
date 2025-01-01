package profolio.server.restapi.exception.handler

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import profolio.server.common.exception.CustomException
import profolio.server.restapi.support.data.ErrorResponse

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(CustomException::class)
    fun customExceptionHandler(exception: CustomException): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(exception.exceptionCode.status)
            .body(ErrorResponse.error(exception.exceptionCode))
    }
}