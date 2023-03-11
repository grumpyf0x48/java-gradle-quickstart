plugins {
    application
    java
    id("org.graalvm.buildtools.native")
}

version = "0.1-SNAPSHOT"

val junitVersion: String by project

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:${junitVersion}")
}

application {
    mainClass.set("org.grumpyf0x48.myapplication.Application")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

tasks.withType<Test> {
    useJUnitPlatform()
}

graalvmNative {
    toolchainDetection.set(false)
}
