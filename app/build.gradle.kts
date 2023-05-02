import extensions.*

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
    DataModule
    DomainModule
    FeaturesModule

    addLocalDependencies()
    addRemoteDependencies()
    addHiltDependencies()

    implementation(libs.io.coil.kt.compose)
    debugImplementation(libs.leakcanary)
}