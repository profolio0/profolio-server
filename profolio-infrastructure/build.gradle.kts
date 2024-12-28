import org.springframework.boot.gradle.tasks.bundling.BootJar

val bootJar: BootJar by tasks

bootJar.enabled = false

dependencies {
    api(project(":profolio-domain:profolio-domain-rds"))
    implementation("org.springframework.boot:spring-boot-starter-security")
}