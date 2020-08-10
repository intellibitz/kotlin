plugins {
    // Apply the application plugin to add support for building a CLI application.
    application
    // Apply the Kotlin JVM plugin to add support for Kotlin.
    kotlin("jvm") version "1.4.0-rc"
    kotlin("kapt") version "1.4.0-rc"
    id("org.jetbrains.dokka") version "1.4.0-rc"
}

version = 0.1
group = "intellibitz"

application {
    // Define the main class for the application.
    mainClass.set("sample.AppKt")
    applicationName = "KotlinLearn"
}

// if normal source directory convention is not followed, define custom sourcesets
sourceSets.main {
    java.srcDirs(listOf("src/main/intellibitz"))
    resources.srcDirs(listOf("src/main/resources"))
}
sourceSets.test {
    java.srcDirs(listOf("src/test/intellibitz"))
    resources.srcDirs(listOf("src/test/resources"))
}

repositories {
    mavenCentral()
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    maven("https://kotlin.bintray.com/kotlinx")
}

dependencies {
    implementation(kotlin("script-runtime"))
    // Use the Kotlin JDK 8 standard library.
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8")
    // Align versions of all Kotlin components
    implementation(kotlin("bom"))
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.0-rc")
    implementation(kotlin("reflect"))
    // Use the Kotlin test library.
    testImplementation(kotlin("test"))
    // Use the Kotlin JUnit integration.
    testImplementation(kotlin("test-junit"))
}
