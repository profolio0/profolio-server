package profolio.server.restapi.support.data

import profolio.server.common.exception.status.StatusCode

interface BaseResponse {
    val status: Int
    val message: String
}

data class Response(
    override val status: Int,
    override val message: String,
): BaseResponse {
    companion object {
        fun ok(message: String) = Response(200, message)
        fun created(message: String) = Response(201, message)
    }
}

data class ResponseData<T>(
    override val status: Int,
    override val message: String,
    val data: T
) : BaseResponse {
    companion object {
        fun <T> ok(data: T) = ResponseData(200, "success", data)
        fun <T> created(data: T) = ResponseData(201, "created", data)
    }
}

data class ErrorResponse(
    override val status: Int,
    override val message: String,
): BaseResponse {
    companion object {
        fun error(status: StatusCode) = ErrorResponse(
            status = status.status,
            message = status.message
        )
    }
}