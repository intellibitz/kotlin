plugins {
    // Apply the application plugin to add support for building a CLI application.
    application
    // Apply the Kotlin JVM plugin to add support for Kotlin.
    kotlin("jvm") version "1.4.0-rc"
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
    // Align versions of all Kotlin components
    implementation(kotlin("bom"))
    // Use the Kotlin test library.
    testImplementation(kotlin("test"))
    // Use the Kotlin JUnit integration.
    testImplementation(kotlin("test-junit"))
}
