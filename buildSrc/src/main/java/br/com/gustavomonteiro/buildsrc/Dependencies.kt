package br.com.gustavomonteiro.buildsrc

internal object Dependencies {
    private const val coroutineVersion = "1.3.5"

    private interface Dependency {
        fun getDependencies(): List<String>

        operator fun invoke(): List<String> {
            return getDependencies()
        }
    }

    object Kotlin : Dependency {
        private const val kotlinVersion = "1.3.72"

        private const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"

        private const val coroutineCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion"
        private const val coroutineAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion"

        override fun getDependencies(): List<String> {
            return listOf(kotlinStdLib, coroutineCore, coroutineAndroid)
        }
    }

    object Ktx : Dependency {
        private const val fragmentKtxVersion = "1.2.4"
        private const val coreKtxVersion = "1.2.0"

        private const val fragmentKtx = "androidx.fragment:fragment-ktx:$fragmentKtxVersion"
        private const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"

        override fun getDependencies(): List<String> {
            return listOf(fragmentKtx, coreKtx)
        }
    }

    object LifeCycle : Dependency {
        private const val lifecycleKtxVersion = "2.2.0"

        private const val lifeCycleKtx =
            "androidx.lifecycle:lifecycle-extensions:$lifecycleKtxVersion"
        private const val viewModelKtx =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleKtxVersion"
        private const val liveDataKtx =
            "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleKtxVersion"

        override fun getDependencies(): List<String> {
            return listOf(lifeCycleKtx, viewModelKtx, liveDataKtx)
        }
    }

    object Android : Dependency {
        private const val appCompatVersion = "1.1.0"
        private const val constraintLayoutVersion = "1.1.3"

        private const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
        private const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"

        override fun getDependencies(): List<String> {
            return listOf(appCompat, constraintLayout)
        }
    }

    object Test : Dependency {
        private const val junitVersion = "4.12"

        private const val junit = "junit:junit:$junitVersion"
        private const val coroutineTest =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutineVersion"

        override fun getDependencies(): List<String> {
            return listOf(junit, coroutineTest)
        }
    }

    object AndroidTest : Dependency {
        private const val junitVersion = "1.1.1"
        private const val espressoVersion = "3.2.0"

        private const val junit = "androidx.test.ext:junit:$junitVersion"
        private const val espresso = "androidx.test.espresso:espresso-core:$espressoVersion"

        override fun getDependencies(): List<String> {
            return listOf(junit, espresso)
        }
    }
}