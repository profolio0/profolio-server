package profolio.server.domain.redis.userToken.service

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component


@Component
class RedisTokenService {
    @Cacheable(value = ["refresh"], key = "#email-#", cacheManager = "redisCacheManager")
    fun setUserToken(email: String, ) {
        TODO("토큰 저장하기")
    }
}