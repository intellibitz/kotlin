buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        maven {
            url = uri("https://dl.bintray.com/kotlin/kotlin-eap")
        }
    }
    dependencies {
//        classpath("org.jetbrains.kotlin:kotlin-jvm:1.4.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.0")
        classpath("com.android.tools.build:gradle:4.0.1")
        classpath("com.google.cloud.tools:appengine-gradle-plugin:2.2.0")
        classpath("org.akhikhl.gretty:gretty:2.0.0")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.4.0")
    }
}
group = "com.intellibitz"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://dl.bintray.com/kotlin/kotlin-eap")
    }
}
