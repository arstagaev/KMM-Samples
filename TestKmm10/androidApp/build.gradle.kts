import com.arstagaev.testkmm10.Versions
import com.arstagaev.testkmm10.Deps
import com.arstagaev.testkmm10.Configuration

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.arstagaev.testkmm10.android"
    compileSdk = Configuration.compileSdk
    defaultConfig {
        applicationId = "com.arstagaev.testkmm10.android"
        minSdk = Configuration.minSdk
        targetSdk = Configuration.targetSdk
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.4"
    }
    packagingOptions {
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":shared"))
    implementation(Deps.Compose.ui)
    implementation(Deps.Compose.uiTooling)
    implementation(Deps.Compose.uiToolingPreview)
    implementation(Deps.Compose.foundation)
    implementation(Deps.Compose.material)
    implementation(Deps.Compose.activity)
    implementation(Deps.Compose.navigation)

    implementation(Deps.Voyager.navigator)
    implementation(Deps.Voyager.bottomSheetNavigator)
    implementation(Deps.Voyager.tabNavigator)
    implementation(Deps.Voyager.transitions)

    implementation(Deps.Koin.composeAndroidX)
    implementation(Deps.Coil)
    implementation(Deps.Accomponist.systemuicontroller)
}
