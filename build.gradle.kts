import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    id("org.jlleitschuh.gradle.ktlint").version("9.2.1")
}

buildscript {
    val kotlinVersion by extra("1.4.10")
    val androidGradleVersion by extra("4.1.1")

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:$androidGradleVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

allprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    ktlint {
        android.set(true)
        verbose.set(true)
        outputToConsole.set(true)
        outputColorName.set("RED")
        ignoreFailures.set(true)
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
        jcenter()
    }
}

tasks.register("clean").configure {
    delete("build")
}
