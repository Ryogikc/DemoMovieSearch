package com.leagueofdevs.demomoviesearch.data.db

import android.app.Application
import androidx.work.Configuration
import com.leagueofdevs.demomoviesearch.BuildConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MoviesApplication : Application(), Configuration.Provider {
    override fun getWorkManagerConfiguration(): Configuration =
        Configuration.Builder()
            .setMinimumLoggingLevel(if (BuildConfig.DEBUG) android.util.Log.DEBUG else android.util.Log.ERROR)
            .build()
}
