plugins {
    id("org.springframework.boot") version "3.0.1"
    id("io.spring.dependency-management") version "1.0.12.RELEASE"
}

dependencies {
    implementation(project(path = ":starlucks-member"))
    implementation(project(path = ":starlucks-payment"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("mysql:mysql-connector-java")
    implementation("org.flywaydb:flyway-core:9.8.1")
    implementation("org.flywaydb:flyway-mysql")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.mockito:mockito-junit-jupiter:4.11.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

tasks {
    bootJar { enabled = true }
    jar { enabled = false }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}