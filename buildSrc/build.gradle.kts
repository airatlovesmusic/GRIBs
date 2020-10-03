plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
    jcenter()
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())

    implementation("com.android.tools.build:gradle:4.0.1")
    implementation(kotlin("gradle-plugin", "1.3.72"))
    implementation(kotlin("android-extensions"))
}