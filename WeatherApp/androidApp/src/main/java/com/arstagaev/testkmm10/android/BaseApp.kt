package com.arstagaev.testkmm10.android

import android.app.Application
import com.arstagaev.testkmm10.android.di.androidModule
import com.arstagaev.testkmm10.di.sharedModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            printLogger(Level.DEBUG)
            androidContext(applicationContext)
            modules(androidModule + sharedModules)
        }
    }
}