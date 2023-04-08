plugins {
    kotlin("jvm") version "1.8.0"
    kotlin("plugin.serialization") version "1.8.0"

    application
}

group = "itmo"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":fromLab5"))
    implementation("com.charleskorn.kaml:kaml:0.52.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.5.0")

    implementation("io.insert-koin:koin-core:3.3.3")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.8.20-RC")
    testImplementation("io.mockk:mockk:1.13.4")
    testImplementation("io.insert-koin:koin-test-junit5:3.3.3")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.8.20-RC")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.8.20-RC")

}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}