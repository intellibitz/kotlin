group = "intellibitz"
version = 0.1

plugins {
    // Apply the application plugin to add support for building a CLI application.
    application
    // Apply the Kotlin JVM plugin to add support for Kotlin.
    kotlin("jvm") version "1.4.0-rc"
    kotlin("kapt") version "1.4.0-rc"
    id("org.jetbrains.dokka") version "1.4.0-rc"
    kotlin("plugin.serialization") version "1.4.0-rc"
}
repositories {
    mavenCentral()
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    maven("https://kotlin.bintray.com/kotlinx")
    maven("https://dl.bintray.com/kotlin/dokka")
}

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
tasks.dokkaHtml {
    outputDirectory = "$buildDir/dokka"
}
/*
tasks.withType<Test> {
    useJUnitPlatform()
}
*/
dependencies {
    implementation(kotlin("script-runtime"))
    // Use the Kotlin JDK 8 standard library.
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8")
    // Align versions of all Kotlin components
    implementation(kotlin("bom"))
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.0-rc")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.20.0") // JVM dependency
    dokkaHtmlPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.4.0-rc")
    implementation(kotlin("reflect"))
    // Use the Kotlin test library.
    testImplementation(kotlin("test"))
    // Use the Kotlin JUnit integration.
    testImplementation(kotlin("test-junit5"))
//    testImplementation("io.kotest:kotest-runner-junit5-jvm:4.1.0") // for kotest framework
//    testImplementation("io.kotest:kotest-assertions-core-jvm:4.1.0") // for kotest core jvm assertions
//    testImplementation("io.kotest:kotest-property-jvm:4.1.0") // for kotest property test
}
