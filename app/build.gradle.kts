plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "uz.uzbekcard.taxiapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "uz.uzbekcard.taxiapp"
        minSdk = 24
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
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://web.lendo.uz/\"")
            buildConfigField("String", "BASE_SOCKED_URL", "\"http://web.lendo.uz/\"")
        }
        debug {
            isMinifyEnabled = false
            buildConfigField("String", "BASE_URL", "\"https://web.lendo.uz/\"")
            buildConfigField("String", "BASE_SOCKED_URL", "\"http://web.lendo.uz/\"")
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
        buildConfig = true
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
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
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

    /**
     * koin
     */
    implementation("io.insert-koin:koin-core:3.4.3")
    implementation("io.insert-koin:koin-android:3.4.3")
    implementation("io.insert-koin:koin-androidx-compose:3.2.2")
    implementation("io.insert-koin:koin-android-compat:3.4.3")


    /**
     * Navigatior
     */
    val voyagerVersion = "1.0.0-rc06"
    implementation("cafe.adriel.voyager:voyager-navigator:$voyagerVersion")
    implementation("cafe.adriel.voyager:voyager-tab-navigator:$voyagerVersion")
    implementation("cafe.adriel.voyager:voyager-transitions:$voyagerVersion")
    implementation("cafe.adriel.voyager:voyager-androidx:$voyagerVersion")
    implementation("cafe.adriel.voyager:voyager-koin:$voyagerVersion")

    /**
     * Ktor
     */
    val ktor_version = "2.3.0"
    implementation ("io.ktor:ktor-client-core:$ktor_version")
    // Ktor network
    implementation ("io.ktor:ktor-client-cio:$ktor_version")
    implementation ("io.ktor:ktor-client-android:$ktor_version")
    implementation ("io.ktor:ktor-client-websockets:$ktor_version")
    implementation ("io.ktor:ktor-client-logging:$ktor_version")
    // Ktor serialization
    implementation ("io.ktor:ktor-client-content-negotiation:$ktor_version")
    implementation( "io.ktor:ktor-client-serialization:$ktor_version")
    implementation ("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")

    /**
     * Lotti
     */
    implementation("com.airbnb.android:lottie-compose:6.0.1")
}