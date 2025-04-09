plugins {
    id("java")
    id("application")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "org.bill"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-simple:2.0.17")
    implementation("net.dv8tion:JDA:5.3.1")
    implementation("io.github.cdimascio:dotenv-java:3.2.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass.set("org.bill.Main")
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveBaseName.set("araxlatanTzogos")
    archiveClassifier.set("all")
    archiveVersion.set("1.0-SNAPSHOT")
    manifest {
        attributes(
            "Main-Class" to "org.bill.Main"
        )
    }
}

tasks.named("jar") {
    enabled = false
}

tasks.named("distZip") {
    dependsOn("shadowJar")
}

tasks.named("distTar") {
    dependsOn("shadowJar")
}
