object BuildPlugin {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val androidGradlePlugin = "com.android.tools.build:gradle:4.0.1"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
}

object Dependencies {
    const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"

    object AndroidX {
        const val core = "androidx.core:core-ktx:1.3.1"
        const val material = "com.google.android.material:material:1.3.0-alpha02"
        const val appCompat = "androidx.appcompat:appcompat:1.2.0"
    }

    const val daggerRuntime = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompile = "com.google.dagger:dagger-compiler:${Versions.dagger}"

    const val ribs = "com.uber.rib:rib-android:${Versions.ribs}"
    const val rxBinding = "com.jakewharton.rxbinding3:rxbinding:${Versions.rxBinding}"

}