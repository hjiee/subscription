package com.hjiee.subscription.ui

import android.app.Application
import com.hjiee.subscription.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Timber 로그 초기화
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        const val DATABASE_NAME = "subscription"
        const val DATABASE_LIMIT = 30
    }
}