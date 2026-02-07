import org.gradle.kotlin.dsl.dependencies

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    `maven-publish`
}

group = "dev.nikdi"
version = libs.versions.periodic.worker.get()

kotlin {
    jvmToolchain(21)
}

java {
    withSourcesJar()
}

ktor {}

dependencies {
    implementation(libs.ktor.server.core)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
    testImplementation(libs.ktor.server.config.yaml)
    testImplementation(libs.kotlinx.coroutines.test)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            artifactId = "periodic-worker"
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/ItzNikDi/PeriodicWorker")
            credentials {
                username = project.property("gpr.user") as String? ?: System.getenv("GITHUB_ACTOR")
                password = project.property("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}