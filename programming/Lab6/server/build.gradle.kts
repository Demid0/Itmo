plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "itmo"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":common"))
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("MainKt")
}