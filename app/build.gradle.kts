plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("29.0.3")

    defaultConfig {
        applicationId = "com.airatlovesmusic.ribs"
        minSdkVersion(23)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles("proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(project(":ribs:root"))
    implementation("androidx.core:core-ktx:1.2.0")
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("com.google.android.material:material:1.3.0-alpha02")
    implementation("androidx.fragment:fragment:1.2.1")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")

    implementation("com.uber.rib:rib-android:0.9.2")
    implementation(project(":global"))
    kapt("com.uber.rib:rib-compiler-test:0.9.2")

    implementation("com.google.dagger:dagger:2.28")
    kapt("com.google.dagger:dagger-compiler:2.28")

    implementation("com.jakewharton.rxbinding3:rxbinding:3.1.0")
}