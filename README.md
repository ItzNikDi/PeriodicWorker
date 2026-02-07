# Periodic Worker

[![version](https://img.shields.io/github/v/release/ItzNikDi/PeriodicWorker?label=version)](https://github.com/ItzNikDi/PeriodicWorker/releases)

A lightweight Ktor plugin for running _periodic background_ tasks.

----

## Installation
### A. Using the version catalog

----
1. Add the plugin to `libs.versions.toml`:

```toml
[versions]
periodic-worker = "0.1.1"

[libraries]
periodic-worker = { module = "dev.nikdi:periodic-worker", version.ref = "periodic-worker" }
```

2. Add the plugin to your `build.gradle.kts`:
```kotlin
dependencies {
    implementation(libs.periodic.worker)
}
```

----
### B. Adding directly to `build.gradle.kts`
```kotlin
dependencies {
    implementation("dev.nikdi:periodic-worker:0.1.1")
}
```
----

## Usage
```kotlin
install(PeriodicWorker) {
    every(30.seconds) {
        println("how time flies by...")
    }
    
    every(5.minutes) {
        clearOldSessions() // or other tasks to run sometimes...
    }
}
```

----

## Testing

Uses virtual time in tests - no actual* delays.

\* One of the tests has a short delay :)