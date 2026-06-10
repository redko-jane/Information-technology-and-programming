import java.util.Properties
import java.time.LocalDateTime

plugins {
    id("java")
    application
    id("com.gradleup.shadow") version "9.4.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

application {
    mainClass = "org.example.Main"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(fileTree("libs") { include("*.jar") })
    implementation(project(":string-utils"))
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.shadowJar {
    manifest {
        attributes("Main-Class" to "org.example.Main")
    }
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

abstract class PrintInfoTask : DefaultTask() {
    @TaskAction
    fun print() {
        println("=============================")
        println("Это моя первая пользовательская задача!")
        println("Проект: ${project.name}")
        println("Версия Gradle: ${project.gradle.gradleVersion}")
        println("=============================")
    }
}

tasks.register<PrintInfoTask>("printInfo") {
    group = "Custom"
    description = "Выводит информацию о проекте"
}

val getGitCommitHash = tasks.register("getGitCommitHash") {
    doLast {
        val hash = try {
            val process = Runtime.getRuntime().exec("git rev-parse --short HEAD")
            process.inputStream.bufferedReader().readText().trim()
        } catch (e: Exception) {
            "unknown"
        }
        val hashFile = project.file("build/tmp/git-hash.txt")
        hashFile.parentFile.mkdirs()
        hashFile.writeText(hash)
        println("Git commit hash: $hash")
    }
}

abstract class GenerateBuildInfoTask : DefaultTask() {
    @TaskAction
    fun generateBuildInfo() {
        val resourcesDir = project.file("src/main/resources")
        resourcesDir.mkdirs()

        val propertiesFile = project.file("src/main/resources/build-passport.properties")

        val buildNumberFile = project.file("build/tmp/build-number.txt")
        var buildNumber = 1
        if (buildNumberFile.exists()) {
            buildNumber = buildNumberFile.readText().trim().toIntOrNull() ?: 1
            buildNumber++
        }
        buildNumberFile.writeText(buildNumber.toString())

        val hashFile = project.file("build/tmp/git-hash.txt")
        val gitCommit = if (hashFile.exists()) hashFile.readText().trim() else "unknown"

        val properties = Properties()
        properties.setProperty("build.username", System.getProperty("user.name") ?: "unknown")
        properties.setProperty("build.os.name", System.getProperty("os.name") ?: "unknown")
        properties.setProperty("build.java.version", System.getProperty("java.version") ?: "unknown")
        properties.setProperty("build.date", LocalDateTime.now().toString())
        properties.setProperty("build.number", buildNumber.toString())
        properties.setProperty("build.git.commit", gitCommit)
        properties.setProperty("build.message", "Hello! The build was completed successfully.")

        properties.store(propertiesFile.outputStream(), "Build Passport")
        println("File build-passport.properties created in src/main/resources/")
        println("Build number: $buildNumber")
        println("Git commit: $gitCommit")
    }
}

tasks.register<GenerateBuildInfoTask>("generateBuildPassport") {
    group = "Custom"
    description = "Generates a file with assembly information (including git commit and build number)"
    dependsOn("getGitCommitHash")
}

tasks.named("processResources") {
    dependsOn(tasks.named("generateBuildPassport"))
}