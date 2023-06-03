package com.arstagaev.testkmm10.android.di

import com.arstagaev.testkmm10.android.detail.DetailViewModel
import com.arstagaev.testkmm10.android.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    viewModel { MainViewModel(get()) }
    viewModel {
        DetailViewModel(
            useCase = get(),
            name = it.get()
        )
    }
}