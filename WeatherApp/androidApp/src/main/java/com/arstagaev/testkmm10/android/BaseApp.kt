package com.arstagaev.testkmm10.android

import android.app.Application
import com.arstagaev.testkmm10.android.di.androidModule
import com.arstagaev.testkmm10.di.sharedModules
import org.koin.core.context.startKoin

class BaseApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(androidModule + sharedModules)
        }
    }
}