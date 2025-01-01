package profolio.server.common.exception.handler

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler()
    fun customExceptionHandler() {
        TODO("구현예정")
    }
}