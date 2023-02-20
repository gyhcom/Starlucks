plugins {
    id("org.springframework.boot") version "3.0.1"
    id("io.spring.dependency-management") version "1.1.0"
}

dependencies {
    implementation(project(path = ":starlucks-common", configuration = null))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.jetbrains:annotations:23.0.0")
}

tasks {
    jar { enabled = true }
    bootJar { enabled = false }
}