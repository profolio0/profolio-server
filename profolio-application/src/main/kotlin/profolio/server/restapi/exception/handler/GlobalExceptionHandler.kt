package profolio.server.restapi.exception.handler

import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import profolio.server.common.exception.CustomException
import profolio.server.common.exception.global.GlobalExceptionCode
import profolio.server.restapi.support.data.ErrorResponse

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(CustomException::class)
    fun customExceptionHandler(exception: CustomException): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(exception.exceptionCode.status)
            .body(ErrorResponse.error(exception.exceptionCode))
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun httpMessageNotReadableExceptionHandler(exception: HttpMessageNotReadableException): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(400)
            .body(ErrorResponse.error(GlobalExceptionCode.BAD_JSON))
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    fun httpRequestMethodNotSupportedExceptionHandler(exception: HttpRequestMethodNotSupportedException): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(404)
            .body(ErrorResponse.error(GlobalExceptionCode.NOT_FOUND))
    }
}