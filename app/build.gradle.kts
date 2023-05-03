import extensions.*
import java.util.*

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    namespace = "com.kurly.app"
    compileSdk = Versions.CompileSdkVersion

    val props = File(rootDir, "gradle.properties").inputStream().use {
        Properties().apply { load(it) }
    }
    val propsVersionCode = (props.getValue("versionCode") as? String)?.toInt() ?: 1
    val propsVersionName = (props.getValue("versionName") as? String) ?: ""

    defaultConfig {
        applicationId = "com.kurly.app"
        minSdk = Versions.MinSdkVersion
        targetSdk = Versions.TargetSdkVersion

        versionCode = propsVersionCode
        versionName = propsVersionName

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