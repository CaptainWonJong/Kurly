import extensions.*
import org.gradle.kotlin.dsl.implementation
import plugins.applyComposeConfig
import plugins.applyHiltPluginConfig

plugins {
    id("kotlin-parcelize")
}

applyHiltPluginConfig()
applyComposeConfig()

dependencies {
    DomainModule
    DesignSystemModule

    addHiltDependencies()
    addComposeDependencies()
    implementation(libs.io.coil.kt.compose)
    implementation(libs.androidx.core.splash)
}

android {
    namespace = "com.kurly.features"
}