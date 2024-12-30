package profolio.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProfolioServerApplication

fun main(args: Array<String>) {
    runApplication<ProfolioServerApplication>(*args)
}
