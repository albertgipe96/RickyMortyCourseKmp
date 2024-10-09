package com.example.rickymortycoursekmp

import android.app.Application
import com.example.rickymortycoursekmp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@App)
        }
    }

}