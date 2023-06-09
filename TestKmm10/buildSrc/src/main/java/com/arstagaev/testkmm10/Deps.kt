package com.arstagaev.testkmm10

import com.arstagaev.testkmm10.Versions

object Deps {

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    }

    object Serialization {
        const val json = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}"
    }

    object KotlinWrappers {
        const val kotlinWrappersBom = "org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:${Versions.kotlinWrappersBom}"
        const val kotlinStyled = "org.jetbrains.kotlin-wrappers:kotlin-styled"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
        const val material = "androidx.compose.material:material:${Versions.compose}"
        const val activity = "androidx.activity:activity-compose:1.7.0"
        const val navigation = "androidx.navigation:navigation-compose:${Versions.navVersion}"
    }

    object Voyager {
        const val navigator = "cafe.adriel.voyager:voyager-navigator:${Versions.voyagerVersion}"
        const val bottomSheetNavigator = "cafe.adriel.voyager:voyager-bottom-sheet-navigator:${Versions.voyagerVersion}"
        const val tabNavigator = "cafe.adriel.voyager:voyager-tab-navigator:${Versions.voyagerVersion}"
        const val transitions = "cafe.adriel.voyager:voyager-transitions:${Versions.voyagerVersion}"
    }

    object Ktor {
        const val core = "io.ktor:ktor-client-core:${Versions.ktor}"
        const val serializationKotlinxJson = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
        const val clientContentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
        const val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"

        // Engines
        const val engineClientAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
        const val engineClientDarwin = "io.ktor:ktor-client-darwin:${Versions.ktor}"
        const val engineClientJava = "io.ktor:ktor-client-java:${Versions.ktor}"
        const val engineClientJs = "io.ktor:ktor-client-js:${Versions.ktor}"
    }

    object Logback {
        const val logbackClassic = "ch.qos.logback:logback-classic:${Versions.logbackClassic}"
    }

    object CashApp {
        object SQLDelight {
            const val gradlePlugin = "app.cash.sqldelight:gradle-plugin:${Versions.sqlDelight}"
            const val androidDriver = "app.cash.sqldelight:android-driver:${Versions.sqlDelight}"
            const val sqliteDriver = "app.cash.sqldelight:sqlite-driver:${Versions.sqlDelight}"
            const val nativeDriver = "app.cash.sqldelight:native-driver:${Versions.sqlDelight}"
            const val sqljsDriver = "app.cash.sqldelight:sqljs-driver:${Versions.sqlDelight}"

            const val coroutinesExtensions = "app.cash.sqldelight:coroutines-extensions:${Versions.sqlDelight}"
            const val primitiveAdapters = "app.cash.sqldelight:primitive-adapters:${Versions.sqlDelight}"
        }
    }

    object Koin {
        const val core = "io.insert-koin:koin-core:${Versions.koin}"
        const val test = "io.insert-koin:koin-test:${Versions.koin}"
        const val android = "io.insert-koin:koin-android:${Versions.koin}"
        const val composeAndroidX = "io.insert-koin:koin-androidx-compose:${Versions.koinComposeAndroidx}"
        const val compose = "io.insert-koin:koin-compose:${Versions.koinCompose}"
        const val composeNavigation = "io.insert-koin:koin-androidx-compose-navigation:${Versions.koinComposeAndroidx}"
    }

    object Accomponist {
        const val systemuicontroller = "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanistVersion}"
    }

    val Coil = "io.coil-kt:coil-compose:${Versions.coilVersion}"
}
