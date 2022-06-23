plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    AppConfig.proguardRules
            )
        }

        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }

        create("internal") {
            isDebuggable = false
            applicationIdSuffix = ".internal"
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
        kotlinCompilerExtensionVersion = Versions.compose
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implementation(project(com.jvrni.buildsrc.Modules.uiSplash))
    implementation(project(com.jvrni.buildsrc.Modules.uiLogin))
    implementation(project(com.jvrni.buildsrc.Modules.uiHome))
    implementation(project(com.jvrni.buildsrc.Modules.uiProfile))
    implementation(project(com.jvrni.buildsrc.Modules.core))
    implementation(project(com.jvrni.buildsrc.Modules.domain))

    //app libs
    implementation(AppDependencies.appLibraries)

    //kapt libs
    kapt(AppDependencies.kaptLibraries)

    //test libs
    testImplementation(AppDependencies.testLibraries)
    androidTestImplementation(AppDependencies.androidTestLibraries)
    debugImplementation(AppDependencies.debugTestLibraries)
}