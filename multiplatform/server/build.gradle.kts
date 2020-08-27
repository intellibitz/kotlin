import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
//    id("org.jetbrains.kotlin.jvm")
    id("com.google.cloud.tools.appengine")
    id("org.akhikhl.gretty")
    application
    war
}

repositories {
    mavenCentral()
    jcenter()
    maven {
        url = uri("https://dl.bintray.com/kotlin/ktor")
    }
    maven {
        url = uri("https://dl.bintray.com/kotlin/kotlin-eap")
    }
    maven {
        url = uri("https://dl.bintray.com/kotlin/kotlinx")
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("script-runtime"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.0.0-RC")
    implementation("io.ktor:ktor-server-servlet:1.4.0")
//    implementation("io.ktor:ktor-server-jetty:1.4.0")
    implementation("io.ktor:ktor-html-builder:1.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.2")
    runtimeOnly("javax.servlet:javax.servlet-api:4.0.1")
    runtimeOnly("com.google.appengine:appengine:1.9.82")
}

application {
    mainClassName = "ServerKt"
}

gretty {
//    contextPath = '/'
    servletContainer = "jetty9"  // What App Engine Flexible uses
}

appengine {
    deploy {   // deploy configuration
        stopPreviousVersion = true  // default - stop the current version
        promote = true              // default - & make this the current version
//        version = 'v1'
//        project = "your GCP project ID"
    }
}

group = "com.intellibitz"   // Generated output GroupId
version = "1.0-SNAPSHOT"          // Version in generated output

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}

// [END gradle]
