plugins {
    id("org.springframework.boot") version "3.0.1"
    id("io.spring.dependency-management") version "1.1.0"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation(project(path = ":starlucks-common", configuration = null))

    implementation("org.junit.jupiter:junit-jupiter-api:5.3.1")
    implementation("org.junit.jupiter:junit-jupiter-engine:5.3.1")
}

tasks {
    jar { enabled = true }
    bootJar { enabled = false }
}