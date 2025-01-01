import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true

dependencies {
    api(project(":profolio-common"))
    api(project(":profolio-infrastructure"))
    api(project(":profolio-domain:profolio-domain-rds"))


    runtimeOnly("com.mysql:mysql-connector-j")
}