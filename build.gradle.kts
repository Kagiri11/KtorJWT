import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    application
}

val ktorVersion = "1.6.7"
val logbackVersion = "1.2.11"
val kmongoCoroutine = "4.5.0"

group = "me.charles.maina"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation( "io.ktor:ktor-server-netty:$ktorVersion")
    implementation ("ch.qos.logback:logback-classic:$logbackVersion")
    implementation ("io.ktor:ktor-serialization:$ktorVersion")
    implementation("io.ktor:ktor-server-sessions:$ktorVersion")

    // Gson
    implementation("io.ktor:ktor-gson:$ktorVersion")

    // K-Mongo
    implementation("org.litote.kmongo:kmongo-coroutine:$kmongoCoroutine")

    //JWT
    implementation("io.ktor:ktor-auth:$ktorVersion")
    implementation("io.ktor:ktor-auth-jwt:$ktorVersion")

    testImplementation ("io.ktor:ktor-server-test-host:$ktorVersion")
    testImplementation ("org.jetbrains.kotlin:kotlin-test")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}