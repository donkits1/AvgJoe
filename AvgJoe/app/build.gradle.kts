plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("plugin.serialization") version "1.5.21"
    //id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.example.avgjoe"
    compileSdk = 34 // 31, 34

    defaultConfig {
        applicationId = "com.example.avgjoe"
        minSdk = 21 // 24
        targetSdk = 34 // 31, 34
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

    implementation("com.google.code.gson:gson:2.8.8")
    implementation ("androidx.navigation:navigation-compose:2.5.0-alpha01")
    implementation("io.ktor:ktor-client-json:1.6.3")
//    implementation("org.jetbrains.kotlin.plugin.serialization")
    implementation("io.ktor:ktor-client-serialization:1.6.3")
//    implementation("io.ktor:ktor-serialization-kotlinx-json:1.6.3")
    implementation("androidx.core:core-ktx:1.6.0") // 1.9.0 - 1.6.0
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1") // 2.8.1 - 2.3.1
    implementation("androidx.activity:activity-compose:1.3.1") // 1.9.0 - 1.3.1
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("io.ktor:ktor-client-logging:1.6.3") // 2.3.11 - 1.6.3
    implementation("io.ktor:ktor-client-core:1.6.3") //
    implementation("io.ktor:ktor-client-cio:1.6.3") //
    implementation("io.ktor:ktor-client-android:1.6.3") //
    implementation("io.ktor:ktor-client-serialization:1.6.3") //
    implementation("io.ktor:ktor-client-logging:1.6.3") //
    implementation("ch.qos.logback:logback-classic:1.2.3") //
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    testImplementation("junit:junit:4.+") // 4.13.2 - 4.+
    androidTestImplementation("androidx.test.ext:junit:1.1.3") // 1.1.5 - 1.1.3
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0") // 3.5.1 - 3.4.0
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}