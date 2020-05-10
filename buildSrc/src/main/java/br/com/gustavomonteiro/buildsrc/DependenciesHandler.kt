package br.com.gustavomonteiro.buildsrc

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.kotlin() {
    Dependencies.Kotlin().forEach {
        implementation(it)
    }
}

fun DependencyHandler.lifecycle() {
    Dependencies.LifeCycle().forEach {
        implementation(it)
    }
}

fun DependencyHandler.ktx() {
    Dependencies.Ktx().forEach {
        implementation(it)
    }
}

fun DependencyHandler.android() {
    Dependencies.Android().forEach {
        implementation(it)
    }
}

fun DependencyHandler.test() {
    Dependencies.Test().forEach {
        testImplementation(it)
    }
}

fun DependencyHandler.androidTest() {
    Dependencies.AndroidTest().forEach {
        testImplementation(it)
    }
}

fun DependencyHandler.retrofit() {
    Dependencies.Retrofit().forEach {
        implementation(it)
    }
}

fun DependencyHandler.glide() {
    Dependencies.Glide.apply {
        kapt(getCompiler())
    }().forEach {
        implementation(it)
    }
}

private fun DependencyHandler.implementation(depName: String) {
    add("implementation", depName)
}

private fun DependencyHandler.testImplementation(depName: String) {
    add("testImplementation", depName)
}

private fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}

private fun DependencyHandler.api(depName: String) {
    add("api", depName)
}