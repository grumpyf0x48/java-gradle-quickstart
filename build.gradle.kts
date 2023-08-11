plugins {
    application
    java
    id("org.graalvm.buildtools.native")
}

val version: String by project
val javaVersion: String by project

val junitVersion: String by project

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:${junitVersion}")
}

application {
    mainClass.set("org.grumpyf0x48.gradle_quickstart.Application")
}

java {
    sourceCompatibility = JavaVersion.toVersion("${javaVersion}")
    targetCompatibility = JavaVersion.toVersion("${javaVersion}")
}

distributions {
    main {
    }
    create("native") {
        contents {
            from("${project.buildDir}/native/nativeCompile") {
                include("gradle_quickstart")
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
            imageName.set("gradle_quickstart")
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

repositories {
    mavenCentral()
}
