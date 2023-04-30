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
    mainClass.set("org.grumpyf0x48.java_gradle_quickstart.Application")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

distributions {
    main {
    }
    create("native") {
        contents {
            from("${project.buildDir}/native/nativeCompile") {
                include("java_gradle_quickstart")
                into("bin")
            }
        }
    }
}

tasks.getByName("nativeDistZip") {
    dependsOn(tasks.nativeCompile)
}

tasks.getByName("nativeDistTar") {
    dependsOn(tasks.nativeCompile)
}

tasks.getByName("installNativeDist") {
    dependsOn(tasks.nativeCompile)
}

graalvmNative {
    toolchainDetection.set(false)
    binaries {
        all {
            resources.autodetect()
        }
        named("main") {
            imageName.set("java_gradle_quickstart")
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

repositories {
    mavenCentral()
}
