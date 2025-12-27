plugins {
	kotlin("jvm") version "2.2.21"
	kotlin("plugin.spring") version "2.2.21"
	id("org.springframework.boot") version "4.0.1"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "xyz.hihasan.ecom"
version = "0.0.1-SNAPSHOT"
description = "E-Commerce BoilerPlate"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
    // Core
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // Persistence
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("org.postgresql:postgresql")

    //TODO - Security - Will enable later
//    implementation("org.springframework.boot:spring-boot-starter-security")
//    implementation("org.springframework.security:spring-security-oauth2-resource-server")

    // Observability
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("io.micrometer:micrometer-registry-prometheus")

    // API Docs
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")

    // Logging
    implementation("net.logstash.logback:logstash-logback-encoder:7.4")

    //TODO - Resilience - Will enable later
//    implementation("io.github.resilience4j:resilience4j-spring-boot3")

    // Dev
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // Testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.mockk:mockk:1.13.10")
    testImplementation("org.assertj:assertj-core")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.register<Exec>("generateOpenApi") {
    group = "documentation"
    description = "Generate OpenAPI specification"

    commandLine(
        "curl",
        "http://localhost:8080/v3/api-docs",
        "-o",
        "${projectDir}/docs/openapi.json"
    )
}
