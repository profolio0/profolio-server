package support.data

data class Response<E>(
    val status: Int,
    val message: String,
    val data: E?
)