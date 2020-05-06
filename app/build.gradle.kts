import br.com.gustavomonteiro.buildsrc.*

plugins{
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion (AndroidConfig.compileSdkVersion)
    buildToolsVersion (AndroidConfig.buildToolsVersion)

    defaultConfig {
        applicationId = "br.com.gustavomonteiro.congressoinformativo"
        minSdkVersion (AndroidConfig.minSdkVersion)
        targetSdkVersion (AndroidConfig.targetSdkVersion)
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    kotlin()
    android()
    lifecycle()
    ktx()
    test()
    androidTest()
}
