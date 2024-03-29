object Libs {
    object Accompanist {
        const val version = "0.22.0-rc"
        const val navigationAnimation =  "com.google.accompanist:accompanist-navigation-animation:$version"
        const val flowLayout = "com.google.accompanist:accompanist-flowlayout:$version"
    }

    object Compose {
        const val version = "1.1.0-beta03"
        const val activity = "androidx.activity:activity-compose:1.4.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.0-rc01"
        const val foundation = "androidx.compose.foundation:foundation:$version"
        const val lifecycle = "androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0"
        const val material = "androidx.compose.material:material:$version"
        const val navigation = "androidx.navigation:navigation-compose:2.4.0-rc01"
        const val ui = "androidx.compose.ui:ui:$version"
        const val uiTooling = "androidx.compose.ui:ui-tooling:$version"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
    }

    object Dagger {
        private const val version = "2.36"
        const val hiltAndroid = "com.google.dagger:hilt-android:$version"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:$version"
    }

    object Hilt {
        private const val version = "1.0.0"
        const val viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
        const val compiler = "androidx.hilt:hilt-compiler:$version"
        const val navigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0-alpha03"
    }


    const val timber = "com.jakewharton.timber:timber:4.7.1"
}