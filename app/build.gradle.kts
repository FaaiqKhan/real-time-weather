import com.practice.realtimeweather.Dependency

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.practice.realtimeweather"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.practice.realtimeweather"
        minSdk = 29
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
    kapt(Dependency.Plugin.HILT_COMPILER)
    kapt(Dependency.Plugin.LIFECYCLE_COMPILER)

    implementation(Dependency.AndroidX.CORE_KTX)
    implementation(Dependency.AndroidX.LIFECYCLE_RUNTIME_KTX)
    implementation(Dependency.AndroidX.ACTIVITY_COMPOSE)
    implementation(platform(Dependency.AndroidX.COMPOSE_BOM))
    implementation(Dependency.AndroidX.COMPOSE_UI)
    implementation(Dependency.AndroidX.COMPOSE_UI_GRAPHICS)
    implementation(Dependency.AndroidX.COMPOSE_UI_TOOLING_PREVIEW)
    implementation(Dependency.AndroidX.COMPOSE_MATERIAL)
    implementation(Dependency.Client.OK_HTTP)
    implementation(Dependency.Client.RETROFIT)
    implementation(Dependency.Coroutine.COROUTINE)
    implementation(Dependency.ViewModel.LIFECYCLE_KTX)
    implementation(Dependency.ViewModel.LIFECYCLE_COMPOSE)
    implementation(Dependency.DependencyInjection.HILT)
    implementation(Dependency.Moshi.MOSHI)
    implementation(Dependency.Moshi.MOSHI_KOTLIN)
    implementation(Dependency.Moshi.MOSHI_CONVERTOR)
    implementation(Dependency.Coin.COIN)
    implementation(Dependency.Pager.PAGER)

    testImplementation(Dependency.JUNIT.J_UNIT)
    testImplementation(Dependency.Test.MOCKK)
    testImplementation(Dependency.Test.COROUTINE)
    testImplementation(Dependency.Test.KOTEST)

    androidTestImplementation(Dependency.AndroidTest.TEST_EXT_JUNIT)
    androidTestImplementation(Dependency.AndroidTest.ESPRESSO_CORE)
    androidTestImplementation(platform(Dependency.AndroidX.COMPOSE_BOM))
    androidTestImplementation(Dependency.AndroidTest.COMPOSE_UI_TEST_JUNIT)

    debugImplementation(Dependency.AndroidDebug.COMPOSE_UI_TOOLING)
    debugImplementation(Dependency.AndroidDebug.COMPOSE_UI_TEST_MANIFEST)
}

kapt {
    correctErrorTypes = true
}