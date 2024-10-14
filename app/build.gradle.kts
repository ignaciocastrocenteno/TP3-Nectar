plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)

    // Lifecycle KTX extensions for managing lifecycles
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Ensuring version compatibility, throughout the entire project solution
    implementation(platform(libs.androidx.compose.bom))

    // Core UI elements for Compose
    implementation(libs.androidx.ui)

    // Graphics functionalities for Compose.
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.material3)

    // Core Espresso library for UI testing.
    implementation(libs.androidx.espresso.core)
    implementation(libs.androidx.constraintlayout.compose)

    // Coil-Compose library
    implementation(libs.coil.compose)
    implementation(libs.coil3.coil.compose)
    implementation(libs.coil.network.okhttp)

    // Retrofit for API calls
    implementation(libs.retrofit)

    // Gson for JSON serialization/deserialization of information
    implementation(libs.converter.gson)

    // Coroutines for asynchronous calls
    implementation(libs.kotlinx.coroutines.android)

    // J-Unit Testing Framework
    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}