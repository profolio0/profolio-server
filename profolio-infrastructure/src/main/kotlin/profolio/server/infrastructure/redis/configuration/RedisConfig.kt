package profolio.server.infrastructure.redis.configuration

import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.StringRedisSerializer
import profolio.server.infrastructure.redis.properties.RedisProperties


@EnableCaching
@Configuration
class RedisConfig(
    private val properties: RedisProperties,
) {
    @Bean
    fun redisConnectionFactory(): RedisConnectionFactory {
        return LettuceConnectionFactory(createStandaloneConfiguration())
    }

    @Bean
    fun redisTemplate(): RedisTemplate<String, Any> {
        val redisTemplate = RedisTemplate<String, Any>().apply {
            connectionFactory = redisConnectionFactory()
            keySerializer = StringRedisSerializer()
            valueSerializer = StringRedisSerializer()
            setDefaultSerializer(StringRedisSerializer())
        }
        
        return redisTemplate
    }

    private fun createStandaloneConfiguration(): RedisStandaloneConfiguration {
        return RedisStandaloneConfiguration(properties.host, properties.port).apply {
            setPassword(properties.password)
        }
    }
}