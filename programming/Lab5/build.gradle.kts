import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.10"
    kotlin("plugin.serialization") version "1.8.10"
    id("org.jetbrains.dokka") version "1.8.10"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.charleskorn.kaml:kaml:0.52.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.5.0")

    implementation("io.insert-koin:koin-core:3.3.3")

    testImplementation(kotlin("test"))

    dokkaHtmlPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.8.10")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.dokkaHtml.configure {
    dependsOn(tasks.build)
    outputDirectory.set(buildDir.resolve("dokka"))
}

application {
    mainClass.set("MainKt")
}