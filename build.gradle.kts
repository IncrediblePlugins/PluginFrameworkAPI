group = "com.github.angeschossen"
version = "1.1.8"
description = "PluginFrameworkAPI"

plugins {
    `java-library`
    `maven-publish`
}

repositories {
    mavenCentral()

    maven {
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")

        // As of Gradle 5.1, you can limit this to only those
        // dependencies you expect from it
        content {
            includeGroup("org.bukkit")
            includeGroup("org.spigotmc")
        }
    }

    /*
    As Spigot-API depends on the BungeeCord ChatComponent-API,
    we need to add the Sonatype OSS repository, as Gradle,
    in comparison to maven, doesn't want to understand the ~/.m2
    directory unless added using mavenLocal(). Maven usually just gets
    it from there, as most people have run the BuildTools at least once.
    This is therefore not needed if you're using the full Spigot/CraftBukkit,
    or if you're using the Bukkit API.
    */
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
    maven { url = uri("https://oss.sonatype.org/content/repositories/central") }
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.21.1-R0.1-SNAPSHOT")
    compileOnly("org.realityforge.org.jetbrains.annotations:org.jetbrains.annotations:1.7.0")
    compileOnly("org.apache.commons:commons-lang3:3.17.0")
}

java {
    withSourcesJar()
    withJavadocJar()
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks {
    jar {
        archiveFileName.set("PluginFrameworkAPI.jar")
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.description
            version = project.version.toString()

            from(components["java"])
        }
    }
}