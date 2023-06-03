package com.arstagaev.testkmm10.util

import com.arstagaev.testkmm10.di.sharedModules
import org.koin.core.context.startKoin

fun initKoin(){
    startKoin {
        modules(sharedModules)
    }
}