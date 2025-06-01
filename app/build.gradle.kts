plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose") version "2.1.21" // Match your Kotlin version
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.parkin"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.parkin"
        minSdk = 23 // Required by latest Firebase Auth
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
    }
    kotlin {
        jvmToolchain(21)
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
}

dependencies {
    // AndroidX AppCompat for classic views and AppCompatActivity
    implementation("androidx.appcompat:appcompat:1.6.1")

    // Firebase BoM for consistent Firebase library versions
    implementation(platform("com.google.firebase:firebase-bom:33.14.0"))

    // Firebase Authentication
    implementation("com.google.firebase:firebase-auth")

    // Google Sign-In for Firebase Auth
    implementation("com.google.android.gms:play-services-auth:21.0.0")

    // Credential Manager for modern Google Sign-In (recommended by Firebase docs)
    implementation("androidx.credentials:credentials:1.3.0")
    implementation("androidx.credentials:credentials-play-services-auth:1.3.0")
    implementation("com.google.android.libraries.identity.googleid:googleid:1.1.1")

    // Jetpack Compose BOM and core libraries
    implementation(platform("androidx.compose:compose-bom:2024.05.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
