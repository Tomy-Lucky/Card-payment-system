import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.3"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.4.30"
	kotlin("plugin.spring") version "1.4.30"
	kotlin("plugin.jpa") version "1.4.30"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	implementation("io.springfox:springfox-swagger2:3.0.0")
	implementation("io.springfox:springfox-swagger-ui:3.0.0")

	//	compile('org.springframework.cloud:spring-cloud-starter-netflix-zuul')
	implementation("org.springframework.cloud:spring-cloud-starter-config:3.0.5")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:3.0.4")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-hystrix:2.2.9.RELEASE")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-hystrix-dashboard:2.2.9.RELEASE")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.cloud:spring-cloud-starter-bootstrap:3.0.4")
	implementation("org.springframework.kafka:spring-kafka:2.7.6")
//	implementation("com.fasterxml.jackson.core:jackson-databind:2.13.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
