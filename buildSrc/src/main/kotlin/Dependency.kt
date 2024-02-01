package com.practice.realtimeweather

object Dependency {

    object AndroidX {

        const val CORE_KTX = "androidx.core:core-ktx:${Version.AndroidX.CORE_KTX}"
        const val LIFECYCLE_RUNTIME_KTX =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Version.AndroidX.RUNTIME_KTX}"
        const val ACTIVITY_COMPOSE =
            "androidx.activity:activity-compose:${Version.AndroidX.ACTIVITY_COMPOSE}"
        const val COMPOSE_BOM = "androidx.compose:compose-bom:2023.08.00"
        const val COMPOSE_UI = "androidx.compose.ui:ui"
        const val COMPOSE_UI_GRAPHICS = "androidx.compose.ui:ui-graphics"
        const val COMPOSE_UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview"
        const val COMPOSE_MATERIAL = "androidx.compose.material3:material3"
    }

    object JUNIT {

        const val J_UNIT = "junit:junit:${Version.JUnit.J_UNIT}"
    }

    object AndroidTest {

        const val TEST_EXT_JUNIT = "androidx.test.ext:junit:${Version.AndroidTest.TEST_EXT_JUNIT}"
        const val ESPRESSO_CORE =
            "androidx.test.espresso:espresso-core:${Version.AndroidTest.ESPRESSO_CORE}"
        const val COMPOSE_UI_TEST_JUNIT = "androidx.compose.ui:ui-test-junit4"
    }

    object AndroidDebug {

        const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling"
        const val COMPOSE_UI_TEST_MANIFEST = "androidx.compose.ui:ui-test-manifest"
    }

    object Client {

        const val OK_HTTP = "com.squareup.okhttp3:okhttp:${Version.Client.OK_HTTP}"
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Version.Client.RETROFIT}"
    }

    object Plugin {

        const val LIFECYCLE_COMPILER =
            "androidx.lifecycle:lifecycle-compiler:${Version.ViewModel.LIFECYCLE}"
        const val HILT_COMPILER =
            "com.google.dagger:hilt-android-compiler:${Version.DependencyInjection.HILT}"
    }

    object Coroutine {

        const val COROUTINE =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.Coroutine.COROUTINE}"
    }

    object ViewModel {

        const val LIFECYCLE_KTX =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.ViewModel.LIFECYCLE}"
        const val LIFECYCLE_COMPOSE =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.ViewModel.LIFECYCLE}"
    }

    object DependencyInjection {

        const val HILT = "com.google.dagger:hilt-android:${Version.DependencyInjection.HILT}"
    }

    object Moshi {

        const val MOSHI = "com.squareup.moshi:moshi:${Version.Moshi.MOSHI}"
        const val MOSHI_KOTLIN = "com.squareup.moshi:moshi-kotlin:${Version.Moshi.MOSHI}"
        const val MOSHI_CONVERTOR =
            "com.squareup.retrofit2:converter-moshi:${Version.Client.RETROFIT}"
    }

    object Coin {

        const val COIN = "io.coil-kt:coil-compose:${Version.Coin.COIN}"
    }

    object Pager {

        const val PAGER =
            "com.google.accompanist:accompanist-pager-indicators:${Version.Pager.PAGER}"
    }

    object Test {

        const val MOCKK = "io.mockk:mockk:${Version.Test.MOCKK}"
        const val COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.Coroutine.COROUTINE}"
        const val KOTEST = "io.kotest:kotest-assertions-core:${Version.Test.KOTEST}"
        const val TURBINE = "app.cash.turbine:turbine:${Version.Test.TURBINE}"
    }
}