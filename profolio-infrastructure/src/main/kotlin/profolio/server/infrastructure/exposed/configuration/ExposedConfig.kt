package profolio.server.infrastructure.exposed.configuration

import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.context.annotation.Configuration
import org.jetbrains.exposed.spring.autoconfigure.ExposedAutoConfiguration

@Configuration
@ImportAutoConfiguration(ExposedAutoConfiguration::class)
class ExposedConfig {
}