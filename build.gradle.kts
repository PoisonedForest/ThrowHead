import kr.entree.spigradle.kotlin.spigot

plugins {
    kotlin("jvm") version "1.3.72"
    id("kr.entree.spigradle") version "1.2.2"
}

group = "xyz.gwcr.clearsky"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.heartpattern.kr/repository/maven-public/") //HeartPattern’s MC maven repo
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    compileOnly(spigot("1.15.2")) // spigot api
}

spigot { // plugin.yml 설정
    authors = listOf("PoisonedForest")
    commands {
        create("던지기아이템") {
            description = "던지기 아이템을 받습니다."
        }
    }
}

val shade = configurations.create("shade")
shade.extendsFrom(configurations.implementation.get())

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    jar {
        from(
            shade.map {
                if (it.isDirectory)
                    it
                else
                    zipTree(it)
            }
        )
    }
}
