object Libs {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"

    // Android Framework
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"

    // Third Party Libraries
    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
    const val GLIDE_TRANSFORMATIONS = "jp.wasabeef:glide-transformations:${Versions.GLIDE_TRANFORMATION}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_GSON_CONVERTER = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val OK_HTTP = "com.squareup.okhttp3:okhttp:${Versions.OK_HTTP}"
    const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.OK_HTTP}"
    const val GSON = "com.google.code.gson:gson:${Versions.GSON}"
    const val HILT = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val HILT_ANNOTATION = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
    const val HILT_VIEWMODEL = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.HILT_VIEWMODEL}"
    const val HILT_COMPILER = "androidx.hilt:hilt-compiler:${Versions.HILT_VIEWMODEL}"
    const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"

}

object TestLibs {
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val TEST_JUNIT = "androidx.test.ext:junit:${Versions.TEST_JUNIT}"
    const val TEST_ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.TEST_ESPRESSO}"
}