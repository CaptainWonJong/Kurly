import extensions.*
import org.gradle.kotlin.dsl.implementation
import plugins.applyHiltPluginConfig
import plugins.applySerializationPluginConfig

applySerializationPluginConfig()
applyHiltPluginConfig()

dependencies {
    DomainModule

    implementation(libs.serialization)
    addRemoteDependencies()
    addLocalDependencies()
    addHiltDependencies()
}

android {
    namespace = "com.kurly.data"
}