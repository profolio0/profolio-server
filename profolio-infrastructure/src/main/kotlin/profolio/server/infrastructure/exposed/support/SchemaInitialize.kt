package profolio.server.infrastructure.exposed.support

import org.jetbrains.exposed.sql.SchemaUtils
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import profolio.server.domain.rds.user.entity.UserEntity

@Component
@Transactional
class SchemaInitialize: ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        SchemaUtils.create(UserEntity)
    }
}