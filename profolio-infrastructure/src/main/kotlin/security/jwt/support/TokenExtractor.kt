package security.jwt.support

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpHeaders
import user.enumeration.TokenType
import java.util.Enumeration

object TokenExtractor {
    fun extract(request: HttpServletRequest, type: TokenType): String {
        val headers: Enumeration<String> = request.getHeaders(HttpHeaders.AUTHORIZATION)

        while (headers.hasMoreElements()) {
            val value: String = headers.nextElement()
            if (value.lowercase().startsWith(type.value.lowercase())) {
                return value.substring(type.value.lowercase().length).trim()
            }
        }

        return ""
    }
}