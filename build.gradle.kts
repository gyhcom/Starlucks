group = "org.example"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "java-library")
    apply(plugin = "checkstyle")

    tasks.withType<Checkstyle> {
        configFile = file("${rootDir}/config/checkstyle/checkstyle.xml")
        configProperties = mapOf("suppressionFile" to "${rootDir}/config/checkstyle/checkstyle/checkstyle-suppressions.xml")
        maxErrors = 0
        maxWarnings = 0
        version = "10.6.0"

        source ("src/main/java")
        include("**/*.java")
    }
}
