plugins {
    id ("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
    buildToolsVersion(AndroidConfig.BUILD_TOOL_VERSION)

    defaultConfig {
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

    implementation(Libs.KOTLIN)
    implementation(Libs.CORE_KTX)

    implementation(Libs.APP_COMPAT)
    implementation(Libs.MATERIAL)
    implementation(Libs.CONSTRAINT_LAYOUT)

    implementation(Libs.GLIDE)
    implementation(Libs.GLIDE_TRANSFORMATIONS)
    implementation(Libs.TIMBER)

    testImplementation(TestLibs.JUNIT)
    androidTestImplementation(TestLibs.TEST_JUNIT)
    androidTestImplementation(TestLibs.TEST_ESPRESSO)
}