package profolio.server.common.exception.status

import org.springframework.http.HttpStatus

interface StatusCode {
    val status: HttpStatus
    val message: String
}