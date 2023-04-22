plugins {
    id("org.springframework.boot") version "3.0.1"
    id("io.spring.dependency-management") version "1.0.12.RELEASE"
}

dependencies {
    implementation(project(path = ":starlucks-member"))
    implementation(project(path = ":starlucks-payment"))
    implementation(project(path = ":starlucks-order"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("mysql:mysql-connector-java")
    implementation("org.flywaydb:flyway-core:9.16.0")
    implementation("org.flywaydb:flyway-mysql")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.mockito:mockito-junit-jupiter:5.2.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
}

tasks {
    bootJar { enabled = true }
    jar { enabled = false }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}