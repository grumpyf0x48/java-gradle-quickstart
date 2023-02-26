plugins {
    application
    java
}

version = "0.1-SNAPSHOT"

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
}

application {
    mainClass.set("org.grumpyf0x48.myapplication.Application")
}

java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

tasks.withType<Test> {
    useJUnitPlatform()
}
