plugins {
    id("org.springframework.boot") version "3.0.1"
    id("io.spring.dependency-management") version "1.1.0"
}

dependencies {
    implementation(project(path = ":starlucks-common", configuration = null))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.jetbrains:annotations:24.0.1")
}

tasks {
    jar { enabled = true }
    bootJar { enabled = false }
}