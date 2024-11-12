plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    ///여기 바뀜///
    kotlin("kapt")
}

android {
    namespace = "com.lion.a061ex_roomdatabase_class"
    ///여기 바뀜///
    compileSdk = 35

    defaultConfig {
        applicationId = "com.lion.a061ex_roomdatabase_class"
        minSdk = 24
        targetSdk = 34
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
        ///여기 바뀜///
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        ///여기 바뀜///
        jvmTarget = "11"
    }
    viewBinding {
        enable = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    ///여기 바뀜///
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler)

}