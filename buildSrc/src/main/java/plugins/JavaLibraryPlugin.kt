package plugins

import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.getByType

fun Project.applyJavaLibraryConfig() {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("java-library")
    }
    extensions.getByType<JavaPluginExtension>().run {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}