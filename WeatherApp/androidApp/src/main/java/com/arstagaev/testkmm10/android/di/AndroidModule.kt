package com.arstagaev.testkmm10.android.di

import com.arstagaev.testkmm10.android.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    viewModel { MainViewModel(get()) }
}
