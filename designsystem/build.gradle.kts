import extensions.*
import org.gradle.kotlin.dsl.implementation
import plugins.applyComposeConfig

applyComposeConfig()

dependencies {
    addComposeDependencies()
    implementation(libs.io.coil.kt.compose)
}

android {
    namespace = "com.kurly.designsystem"
}