package profolio.server.restapi.support.data

interface BaseResponse {
    val status: Int
    val message: String
}

data class Response(
    override val status: Int,
    override val message: String,
): BaseResponse {
    companion object {
        fun success(message: String) = Response(200, message)
        fun error(message: String, status: StatusCode) = Response(status.status.value(), message)
    }
}

data class ResponseData<T>(
    override val status: Int,
    override val message: String,
    val data: T
) : BaseResponse