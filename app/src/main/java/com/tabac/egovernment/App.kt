package com.tabac.egovernment

import android.app.Application
import timber.log.Timber

import timber.log.Timber.*

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initLogger()
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}