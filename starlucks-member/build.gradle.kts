plugins {
    id("org.springframework.boot") version "3.0.1"
    id("io.spring.dependency-management") version "1.1.0"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(project(path = ":starlucks-common", configuration = null))
}

tasks {
    jar { enabled = true }
    bootJar { enabled = false }
}