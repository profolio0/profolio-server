package restapi

import org.springframework.http.HttpStatus

interface StatusCode {
    val status: HttpStatus
    val message: String
}

enum class ErrorStatusCode(
    override val status: HttpStatus,
    override val message: String,
): StatusCode {
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad Request"),
}