buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath ("com.android.tools.build:gradle:4.0.0-beta05")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean").configure {
    delete("build")
}