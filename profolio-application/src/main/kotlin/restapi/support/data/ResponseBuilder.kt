package restapi.support.data

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

object ResponseBuilder {
    fun <E> ok(message: String, data: E?): ResponseEntity<Response<E>> {
        return ResponseEntity(
            Response(
                status = HttpStatus.OK.value(),
                message = message,
                data = data
            ),
            HttpStatus.OK
        )
    }

    fun <E> created(message: String, data: E?): ResponseEntity<Response<E>> {
        return ResponseEntity(
            Response(
                status = HttpStatus.CREATED.value(),
                message = message,
                data = data
            ),
            HttpStatus.CREATED
        )
    }

    fun error(statusCode: StatusCode): ResponseEntity<Response<Nothing>> {
        return ResponseEntity(
            Response(
                status = statusCode.status.value(),
                message = statusCode.message,
                data = null
            ),
            statusCode.status
        )
    }
}