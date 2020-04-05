import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") version "2.2.6.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    `java-library`
}

val jar: Jar by tasks
val bootJar: BootJar by tasks

jar.enabled = true
bootJar.enabled = false

dependencies {
    api(project(":book-spring-boot-autoconfigure"))
}
