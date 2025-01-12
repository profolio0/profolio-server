package profolio.server.infrastructure.redis.configuration

import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer
import profolio.server.infrastructure.redis.properties.RedisProperties
import java.time.Duration


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

    @Bean(name = ["cacheManager"])
    fun cacheManager(connectionFactory: RedisConnectionFactory?): RedisCacheManager {
        val configuration: RedisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
            .disableCachingNullValues()
            .entryTtl(Duration.ofHours(24))
            .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(StringRedisSerializer()))
            .serializeValuesWith(
                RedisSerializationContext.SerializationPair.fromSerializer<Any>(
                    GenericJackson2JsonRedisSerializer()
                )
            )
        return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(connectionFactory!!)
            .cacheDefaults(configuration).build()
    }

    private fun createStandaloneConfiguration(): RedisStandaloneConfiguration {
        return RedisStandaloneConfiguration(properties.host, properties.port).apply {
            setPassword(properties.password)
        }
    }
}