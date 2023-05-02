package extensions

import ModulePath
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the

fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? =
    add("debugImplementation", dependencyNotation)

fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

fun Project.addHiltDependencies() {
    project.dependencies {
        implementation(libs.hilt.android)
        kapt(libs.hilt.compiler)
    }
}

fun Project.addRemoteDependencies() {
    project.dependencies {
        implementation(libs.okhttp)
        implementation(libs.logging.interceptor)
        implementation(libs.converter.serialization)
        implementation(libs.retrofit)
    }
}

fun Project.addLocalDependencies() {
    project.dependencies {
        implementation(libs.room.ktx)
        kapt(libs.room.compiler)
        implementation(libs.room.runtime)
    }
}

fun Project.addComposeDependencies() {
    project.dependencies {

        implementation(libs.androidx.accompanist.placeholder)
        implementation(libs.androidx.accompanist.placeholder.material)

        val composeBom = platform(libs.androidx.compose.bom)
        implementation(composeBom)
        implementation(libs.androidx.compose.foundation)
        implementation(libs.androidx.compose.material3)
        implementation(libs.androidx.compose.ui)
        implementation(libs.androidx.compose.ui.tooling.preview)
        debugImplementation(libs.androidx.compose.ui.tooling)

        implementation(libs.androidx.compose.activity)
        implementation(libs.androidx.compose.hilt.navigation)
        implementation(libs.androidx.compose.constraintlayout)
        implementation(libs.androidx.compose.lifecycle.viewmodel)
        implementation(libs.androidx.compose.lifecycle.runtime)
    }
}

private val Project.libs get() = the<LibrariesForLibs>()

val DependencyHandler.DataModule
    get() = implementation(project(mapOf("path" to ModulePath.Data)))

val DependencyHandler.DomainModule
    get() = implementation(project(mapOf("path" to ModulePath.Domain)))

val DependencyHandler.FeatureModule
    get() = implementation(project(mapOf("path" to ModulePath.Feature)))

val DependencyHandler.DesignSystemModule
    get() = implementation(project(mapOf("path" to ModulePath.DesignSystem)))
