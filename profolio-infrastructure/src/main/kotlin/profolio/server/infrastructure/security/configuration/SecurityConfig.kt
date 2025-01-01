package profolio.server.infrastructure.security.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import profolio.server.infrastructure.security.jwt.filter.TokenFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
    val tokenFilter: TokenFilter
) {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .formLogin{ it.disable() }
            .httpBasic{ it.disable() }
            .cors{ it.disable() }

            .addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter::class.java)

            .authorizeHttpRequests{ request ->
                request
                    .requestMatchers("/auth/*").permitAll()
                    .anyRequest().authenticated()
            }
        return http.build()
    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}