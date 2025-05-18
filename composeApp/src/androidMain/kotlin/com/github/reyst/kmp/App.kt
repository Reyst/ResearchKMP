package com.github.reyst.kmp

import android.app.Application
import com.github.reyst.kmp.di.appModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
        }
    }
}