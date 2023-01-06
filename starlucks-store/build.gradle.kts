plugins {
    id("org.springframework.boot") version "3.0.1"
    id("io.spring.dependency-management") version "1.1.0"

    application
    idea
}

java.sourceCompatibility = JavaVersion.VERSION_17

dependencies {
    implementation(project(path = ":starlucks-common"))

    implementation("org.springframework.boot:spring-boot-starter-web")
}
