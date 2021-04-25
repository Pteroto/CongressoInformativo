package br.com.gustavomonteiro.buildsrc

object Dependencies {
    private const val coroutineVersion = "1.4.1"
    const val composeVersion = "1.0.0-beta01"

    private interface Dependency {
        fun getDependencies(): List<String>

        operator fun invoke(): List<String> {
            return getDependencies()
        }
    }

    object Kotlin : Dependency {
        private const val kotlinVersion = "1.4.32"

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
        private const val constraintLayoutVersion = "2.0.0-beta6"
        private const val recyclerViewVersion = "28.0.0"
        private const val cardViewVersion = "28.0.0"
        private const val materialComponentsVersion = "1.1.0"

        private const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
        private const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
        private const val recyclerView = "com.android.support:recyclerview-v7:$recyclerViewVersion"
        private const val cardView = "com.android.support:cardview-v7:$cardViewVersion"
        private const val materialComponents =
            "com.google.android.material:material:$materialComponentsVersion"

        override fun getDependencies(): List<String> {
            return listOf(appCompat, constraintLayout, recyclerView, cardView, materialComponents)
        }
    }

    object Test : Dependency {
        private const val junitVersion = "4.13"

        private const val junit = "junit:junit:$junitVersion"
        private const val coroutineTest =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutineVersion"

        override fun getDependencies(): List<String> {
            return listOf(junit, coroutineTest)
        }
    }

    object AndroidTest : Dependency {
        private const val junitVersion = "1.1.2"
        private const val espressoVersion = "3.2.0"

        private const val junit = "androidx.test.ext:junit:$junitVersion"
        private const val espresso = "androidx.test.espresso:espresso-core:$espressoVersion"
        private const val compose = "androidx.compose.ui:ui-test-junit4:$composeVersion"

        override fun getDependencies(): List<String> {
            return listOf(junit, espresso)
        }
    }

    object Retrofit : Dependency {
        private const val retrofitVersion = "2.8.2"

        private const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        private const val retrofitAdapter =
            "com.squareup.retrofit2:converter-moshi:$retrofitVersion"

        override fun getDependencies(): List<String> {
            return listOf(retrofit, retrofitAdapter)
        }
    }

    object Glide : Dependency {
        private const val glideVersion = "4.11.0"

        private const val glide = "com.github.bumptech.glide:glide:$glideVersion"
        private const val glideCompiler = "com.github.bumptech.glide:compiler:$glideVersion"

        override fun getDependencies(): List<String> {
            return listOf(glide)
        }

        fun getCompiler(): List<String> {
            return listOf(glideCompiler)
        }
    }

    object Dagger : Dependency {
        private const val daggerVersion = "2.27"

        private const val dagger = "com.google.dagger:dagger:$daggerVersion"
        private const val daggerCompiler = "com.google.dagger:dagger-compiler:$daggerVersion"
        private const val daggerAndroid = "com.google.dagger:dagger-android:$daggerVersion"
        private const val daggerAndroidCompiler =
            "com.google.dagger:dagger-android-processor:$daggerVersion"

        override fun getDependencies(): List<String> {
            return listOf(dagger, daggerAndroid)
        }

        fun getCompiler(): List<String> {
            return listOf(daggerCompiler, daggerAndroidCompiler)
        }
    }

    object Compose : Dependency {
        private const val composeActivityVersion = "1.3.0-alpha03"
        private const val composeViewModelVersion = "1.0.0-alpha02"

        private const val composeUi = "androidx.compose.ui:ui:$composeVersion"
        private const val composeUiTooling = "androidx.compose.ui:ui-tooling:$composeVersion"
        private const val composeFoundation =
            "androidx.compose.foundation:foundation:$composeVersion"
        private const val composeMaterial = "androidx.compose.material:material:$composeVersion"
        private const val composeMaterialIconsCore =
            "androidx.compose.material:material-icons-core:$composeVersion"
        private const val composeMaterialIconsExtended =
            "androidx.compose.material:material-icons-extended:$composeVersion"
        private const val composeLiveData =
            "androidx.compose.runtime:runtime-livedata:$composeVersion"
        private const val composeActivity =
            "androidx.activity:activity-compose:$composeActivityVersion"
        private const val composeViewModel =
            "androidx.lifecycle:lifecycle-viewmodel-compose:$composeViewModelVersion"

        override fun getDependencies(): List<String> {
            return listOf(
                composeUi,
                composeUiTooling,
                composeFoundation,
                composeMaterial,
                composeMaterialIconsCore,
                composeMaterialIconsExtended,
                composeLiveData,
                composeActivity,
                composeViewModel
            )
        }
    }
}