import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.google.services)

}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_18)
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            export(libs.kmpnotifier)
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        //val commonMain by getting

        iosMain.dependencies {

        }
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(compose.material3)
            implementation(libs.material3)
            implementation(libs.androidx.activity.compose)
            implementation(libs.ui.tooling)
            implementation(libs.ui.tooling.preview)
            implementation(libs.android.accompanist)
            implementation(libs.android.splash.screen)

            // DI with Koin
            implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)

            // Networking with Ktor
            implementation(libs.ktor.client.okhttp)

            // Notification Handling
            implementation(libs.firebase.messaging.ktx)

        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            implementation(libs.android.navigation)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)

            // DI with Koin
            api(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.composeVM)

            // Networking with Ktor
            implementation(libs.bundles.ktor)

            // AsyncImage with Coil
            implementation(libs.bundles.coil)


            // DataStore For LocalData
            api(libs.datastore.preferences)
            api(libs.datastore)
            api(libs.kotlin.serialization)


            // peekaboo-image-picker
            implementation(libs.peekaboo.image.picker)

            // notification library
            api(libs.kmpnotifier)

        }

        nativeMain.dependencies {
            // Networking with Ktor
            implementation(libs.ktor.client.darwin)
        }

    }
}

android {
    namespace = "org.example.project"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "com.bedaati.app"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    buildFeatures {
        compose = true
    }
    dependencies {
        implementation(libs.ui.tooling)
        implementation(libs.ui.tooling.preview)
        debugImplementation(compose.uiTooling)
    }

}


