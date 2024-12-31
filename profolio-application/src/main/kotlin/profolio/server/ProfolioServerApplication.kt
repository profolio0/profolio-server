package profolio.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class ProfolioServerApplication

fun main(args: Array<String>) {
    @Suppress("SpreadOperator")
    runApplication<ProfolioServerApplication>(*args)
}
