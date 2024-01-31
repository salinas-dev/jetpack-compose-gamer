plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.salinas.gamermvvm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.salinas.gamermvvm"
        minSdk = 25
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("commons-io:commons-io:2.7")
    implementation("com.google.dagger:hilt-android:2.44")
    implementation("com.google.firebase:firebase-auth:22.3.0")
    implementation("androidx.wear.compose:compose-material:1.2.1")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
    implementation("androidx.hilt:hilt-navigation-compose")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("androidx.navigation:navigation-compose:2.5.3")
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.compose.ui:ui:1.0.5")
    implementation("androidx.compose.material3:material3:1.0.0")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    // Ejemplo de dependencia de Firebase Auth
    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.38.1")  // Use the latest version
    kapt("com.google.dagger:hilt-android-compiler:2.38.1")
    // Import the BoM for the Firebase platform
    implementation(platform("com.google.firebase:firebase-bom:32.6.0"))
    //GSON
    implementation("com.google.code.gson:gson:2.8.9")
    // Declare the dependency for the Cloud Firestore library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-firestore")
    //image
    implementation("io.coil-kt:coil-compose:2.5.0")
    // Import the BoM for the Firebase platform
    implementation(platform("com.google.firebase:firebase-bom:32.6.0"))

    // Add the dependency for the Cloud Storage library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-storage")

    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("androidx.compose.ui:ui:1.1.0")
    implementation("androidx.compose.material:material:1.1.0")
    implementation("androidx.compose.ui:ui-tooling:1.1.0")
    implementation("androidx.navigation:navigation-compose:2.5.3")




}
// Allow references to generated code
kapt {
    correctErrorTypes = true
}
