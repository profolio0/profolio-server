package profolio.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProfolioServerApplication

fun main(args: Array<String>) {
    @Suppress("SpreadOperator")
    runApplication<ProfolioServerApplication>(*args)
}
