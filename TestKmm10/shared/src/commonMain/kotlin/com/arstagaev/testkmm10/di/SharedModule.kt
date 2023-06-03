package com.arstagaev.testkmm10.di

import com.arstagaev.testkmm10.data.remote.TKClient
import com.arstagaev.testkmm10.data.remote.createHttpClient
import com.arstagaev.testkmm10.data.repository.AnimeRepositoryImpl
import com.arstagaev.testkmm10.domain.interactor.GetWeatherByCityUseCase
import com.arstagaev.testkmm10.domain.repository.IWeatherRepository
import com.arstagaev.testkmm10.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    single { createHttpClient(true) }
    single { TKClient(client = get()) }
}
private val utilityModule = module {
    factory {
        provideDispatcher()
    }
}

private val domainModule = module {
    single<IWeatherRepository> {
        AnimeRepositoryImpl()
    }
    factory { GetWeatherByCityUseCase() }
}
val sharedModules = listOf(dataModule, utilityModule, domainModule)