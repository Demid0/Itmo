import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
    kotlin("plugin.serialization") version "1.8.10"

    id("org.openjfx.javafxplugin") version "0.0.8"
    id("org.jetbrains.dokka") version "1.8.10"

    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":client"))
    implementation(project(":common"))
    implementation(project(":server"))

    implementation("io.insert-koin:koin-core:3.3.3")

    implementation("no.tornado:tornadofx:1.7.19")
    implementation("org.openjfx:javafx:1.7.19")
    implementation("org.openjfx:javafx-base:11.0.2")
    implementation("org.openjfx:javafx-controls:11.0.2")
}

javafx {
    version = "11.0.2"
    modules = mutableListOf("javafx.controls", "javafx.graphics")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

application {
    mainClass.set("MainKt")
}
