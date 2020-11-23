plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
    buildToolsVersion(AndroidConfig.BUILD_TOOL_VERSION)

    defaultConfig {
        applicationId(AndroidConfig.APPLICATION_ID)
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
        versionCode(AndroidConfig.VERSION_CODE)
        versionName(AndroidConfig.VERSION_NAME)

        testInstrumentationRunner(AndroidConfig.TEST_INSTRUMENTATION_RUNNER)
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        dataBinding = true
    }
    androidExtensions {
        isExperimental = true
    }
}

dependencies {

    api(project(":base"))
    implementation(Libs.APP_COMPAT)
    implementation(Libs.MATERIAL)
    implementation(Libs.CONSTRAINT_LAYOUT)

    implementation(Libs.COROUTINES_CORE)
    implementation(Libs.COROUTINES_ANDROID)
    implementation(Libs.LIFECYCLE_VIEW_MODEL_KTX)
    implementation(Libs.ACTIVITY_KTX)
    implementation(Libs.FRAGMENT_KTX)
    implementation(Libs.HILT)
    implementation(Libs.HILT_VIEWMODEL)

    implementation(Libs.ROOM_RUNTIME)
    implementation(Libs.ROOM_RXJAVA2)
    implementation(Libs.ROOM_KTX)
    kapt(Libs.ROOM_COMPILER)

    implementation(Libs.RX_JAVA)
    implementation(Libs.RX_KOTLIN)
    implementation(Libs.RX_ANDROID)
    implementation(Libs.RX_RETROFIT)
    implementation(Libs.TIMBER)

    kapt(Libs.HILT_ANNOTATION)
    kapt(Libs.HILT_COMPILER)

}