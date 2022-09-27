import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
}

buildscript {
    val kotlinVersion by extra("1.7.0")
    val androidGradleVersion by extra("7.3.0")
    val hiltVersion by extra("2.42")

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:$androidGradleVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
    }
}

configure(
    subprojects.filter {
        !listOf("buildSrc", "core").contains(it.name)
    }
) {
    apply(plugin = "dagger.hilt.android.plugin")
}

allprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    ktlint {
        android.set(true)
        verbose.set(true)
        outputToConsole.set(true)
        outputColorName.set("RED")
        ignoreFailures.set(true)
        disabledRules.set(setOf("no-wildcard-imports"))
        reporters {
            reporter(ReporterType.HTML)
            reporter(ReporterType.CHECKSTYLE)
        }
        filter {
            exclude("**/generated/**")
            exclude("**/*Test.kt")
        }
    }

    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean").configure {
    delete("build")
}
