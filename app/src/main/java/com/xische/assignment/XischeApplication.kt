package com.xische.assignment

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class XischeApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}