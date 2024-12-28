import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true

subprojects {
    dependencies {

    }
    jar.enabled = true
    bootJar.enabled = false
}