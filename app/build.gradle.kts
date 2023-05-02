import extensions.*
import plugins.applyComposeConfig

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    namespace = "com.kurly.app"
    compileSdk = Versions.CompileSdkVersion

    defaultConfig {
        applicationId = "com.kurly.app"
        minSdk = Versions.MinSdkVersion
        targetSdk = Versions.TargetSdkVersion

        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    addLocalDependencies()
    addRemoteDependencies()
    addHiltDependencies()

    implementation(libs.io.coil.kt.compose)
    debugImplementation(libs.leakcanary)
}