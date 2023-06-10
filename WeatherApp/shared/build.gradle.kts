import com.arstagaev.testkmm10.Deps
import com.arstagaev.testkmm10.Configuration

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("kotlin-parcelize")
    id("app.cash.sqldelight")
    id("kotlinx-serialization")
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = Configuration.versionName
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Deps.Coroutines.core)
                implementation(Deps.Ktor.core)
                implementation(Deps.Ktor.clientContentNegotiation)
                implementation(Deps.Ktor.serializationKotlinxJson)
                implementation(Deps.Ktor.clientLogging)
                api(Deps.Koin.core)
                implementation(Deps.Serialization.json)


                with(Deps.SQLDelight) {
                    api(coroutinesExtensions)
                    api(primitiveAdapters)
                }
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Deps.Ktor.engineClientAndroid)
                api(Deps.Koin.android)

                // SqlDelight
                implementation(Deps.SQLDelight.androidDriver)
            }
        }
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependencies{
                implementation(Deps.Ktor.engineClientDarwin)

                implementation(Deps.SQLDelight.nativeDriver)
            }
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.arstagaev.testkmm10"
    compileSdk = Configuration.compileSdk
    defaultConfig {
        minSdk = Configuration.minSdk
    }
}

sqldelight {
    databases {
        create("WeatherDatabase") {
            //sqldelight/com/arstagaev/testkmm10/cache/AppDatabase.sq
            packageName.set("com.arstagaev.testkmm10.cache")
        }
    }
}