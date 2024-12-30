import org.springframework.boot.gradle.tasks.bundling.BootJar

val bootJar: BootJar by tasks

bootJar.enabled = false

dependencies {
    implementation("org.jetbrains.exposed:exposed-spring-boot-starter:0.57.0")
    api(project(":profolio-domain:profolio-domain-rds"))
}