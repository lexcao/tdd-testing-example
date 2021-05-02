plugins {
    java
    id("io.freefair.lombok") version "6.0.0-m2"
    kotlin("jvm") version "1.5.0-RC"
}

group = "io.github.lexcao"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    // for Java mocking and assertion
    testImplementation("org.mockito:mockito-core:3.9.0")
    testImplementation("org.assertj:assertj-core:3.19.0")

    // for Kotlin mocking and assertion
    testImplementation("io.mockk:mockk:1.11.0")
    testImplementation("io.kotest:kotest-assertions-core:4.4.3")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks {
    test {
        useJUnitPlatform()
    }
}
