package com.example.techtest

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TechTestApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        //init libs if required
    }
}