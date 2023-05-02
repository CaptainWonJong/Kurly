plugins {
    id(libs.plugins.android.application.get().pluginId) apply false
    id(libs.plugins.android.library.get().pluginId) apply false
    id(libs.plugins.kotlin.android.get().pluginId) apply false
    id(libs.plugins.kotlin.jvm.get().pluginId) apply false
    kotlin(libs.plugins.serialization.get().pluginId) version libs.versions.kotlin
    alias(libs.plugins.hilt) apply false
}
