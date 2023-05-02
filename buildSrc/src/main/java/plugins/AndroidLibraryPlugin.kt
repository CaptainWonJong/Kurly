package plugins

import ModulePath
import Versions
import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.BaseExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.the
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun Project.applyAndroidLibraryConfig() {
    apply {
        plugin("com.android.library")
        plugin("kotlin-android")
        plugin("kotlin-kapt")
    }
    extensions.getByType<BaseExtension>().run {
        compileSdkVersion(Versions.CompileSdkVersion)

        defaultConfig {
            minSdk = Versions.MinSdkVersion
            targetSdk = Versions.TargetSdkVersion

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            consumerProguardFile("consumer-rules.pro")
        }

        buildTypes {
            getByName("release") {
                minifyEnabled(true)
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
                )
            }
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        tasks.withType<KotlinCompile>().configureEach {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_1_8.toString()
            }
        }
    }
}

fun Project.applyHiltPluginConfig() {
    apply {
        plugin("dagger.hilt.android.plugin")
    }
}

fun Project.applySerializationPluginConfig() {
    apply {
        plugin("kotlinx-serialization")
    }
}

fun Project.applyComposeConfig() {
    extensions.getByType<BaseExtension>().run {
        buildFeatures.compose = true

        composeOptions {
            kotlinCompilerExtensionVersion = libs.versions.compose.get()
        }
    }
}

private val Project.libs get() = the<LibrariesForLibs>()
private val Project.libExt get() = the<LibraryExtension>()
private val Project.appExt get() = the<ApplicationExtension>()