plugins {
    java
    checkstyle
}

dependencies {
    testImplementation("org.mockito:mockito-junit-jupiter:4.11.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

subprojects {
    apply {
        checkstyle
    }

    java.sourceCompatibility = JavaVersion.VERSION_17
    java.targetCompatibility = JavaVersion.VERSION_17

    checkstyle {
        toolVersion = "10.3.2"
        isIgnoreFailures = false
        maxErrors = 0

        configFile = file("${project.rootDir}/config/checkstyle.xml")
        configProperties = mapOf("suppressionFile" to "${project.rootDir}/config/checkstyle/checkstyle/checkstyle-suppressions.xml")
    }
}

