package profolio.server.domain.redis.userToken.service

import org.springframework.cache.annotation.Cacheable
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component


@Component
class RedisTokenService(
    val redisTemplate: RedisTemplate<String, Any>
) {
    @Cacheable(value = ["refresh"], key = "#email-#userAgent", cacheManager = "redisCacheManager")
    fun setUserToken(
        email: String,
        userAgent: String,
        token: String
    ) {
        redisTemplate.opsForValue().set(email, userAgent, token)
    }
}