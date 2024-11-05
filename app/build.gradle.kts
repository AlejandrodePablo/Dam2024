plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.navigation.safeargs.kotlin)
    alias(libs.plugins.ksp)
}

android {
    namespace = "edu.iesam.dam2024"
    compileSdk = 35

    defaultConfig {
        applicationId = "edu.iesam.dam2024"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        viewBinding = true
    }
}

dependencies {

    //Librerias para la app
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.gson.serializer)
    implementation(libs.glide)
    implementation(libs.coil)
    implementation(libs.viewmodel.scope)
    implementation(libs.nav.ui.ktx)
    implementation(libs.nav.fragment.ktx)
    implementation(libs.retro)
    implementation(libs.gson.retro)
    api(libs.nav.fragment.ktx)

    //Librerias de DI (kotlin)
    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.android)
    implementation(libs.koin.annotations)

    //KSP
    ksp(libs.koin.ksp)

    //okhttp
    implementation(libs.okhttp.log.interceptor)

    //Librerías para testing
    testImplementation(libs.junit)

    //Librerías para Android-testing
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

}
ksp {
    arg("KOIN_CONFIG_CHECK", "true")
}
