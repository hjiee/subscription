object Libs {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"

    // Android Framework
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val COORDINATOR_LAYOUT = "androidx.coordinatorlayout:coordinatorlayout:${Versions.COORDINATOR_LAYOUT}"
    const val ROOM_RUNTIME =  "androidx.room:room-runtime:${Versions.ROOM}"
    const val ROOM_RXJAVA2 =  "androidx.room:room-rxjava2:${Versions.ROOM}"
    const val ROOM_KTX =  "androidx.room:room-ktx:${Versions.ROOM}"
    const val ROOM_GUAVA =  "androidx.room:room-guava:${Versions.ROOM}"
    const val ROOM_COMPILER =  "androidx.room:room-compiler:${Versions.ROOM}"
    const val LIFECYCLE_VIEW_MODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
    const val ACTIVITY_KTX = "androidx.activity:activity-ktx:${Versions.ACTIVITY_KTX}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"

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
    const val RX_JAVA =  "io.reactivex.rxjava2:rxjava:${Versions.RX_JAVA}"
    const val RX_KOTLIN =  "io.reactivex.rxjava2:rxkotlin:${Versions.RX_KOTLIN}"
    const val RX_ANDROID =  "io.reactivex.rxjava2:rxandroid:${Versions.RX_ANDROID}"
    const val RX_RETROFIT =  "com.squareup.retrofit2:adapter-rxjava2:${Versions.RX_RETROFIT}"

    // firebase
    const val FIREBASE_BOM = "com.google.firebase:firebase-bom:${Versions.FIREBASE_BOM}"
    const val ANALYTICS = "com.google.firebase:firebase-analytics-ktx"
    const val CRASHLYTICS = "com.google.firebase:firebase-crashlytics-ktx"
    const val FIRESTORE = "com.google.firebase:firebase-firestore:${Versions.FIRESTORE}"

}

object TestLibs {
    const val JUNIT = "junit:junit:${Versions.TEST_JUNIT}"
    const val TEST_JUNIT = "androidx.test.ext:junit:${Versions.TEST_X_JUNIT}"
    const val TEST_ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.TEST_ESPRESSO}"
}