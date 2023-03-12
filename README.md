# java-gradle-quickstart

[![Build](https://github.com/grumpyf0x48/java-gradle-quickstart/actions/workflows/gradle.yml/badge.svg)](https://github.com/grumpyf0x48/java-gradle-quickstart/actions/workflows/gradle.yml)

java-gradle-quickstart is a template repository to bootstrap a new Java
application using:

- Java 17
- Gradle 8 with Kotlin DSL for build
- GraalVM for native build
- Maven Central for dependencies
- JUnit 5 for tests
- EditorConfig for code formatting
- Renovate for dependencies update
- GitHub workflow for running tests

## Run application

```shell
./gradlew run

> Task :run
Hello World!
```

```shell
./gradlew nativeRun

> Task :nativeRun
Hello World!
```
