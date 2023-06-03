package com.arstagaev.testkmm10.di

import com.arstagaev.testkmm10.data.remote.AnimeApi
import com.arstagaev.testkmm10.data.remote.RemoteDataSource
import com.arstagaev.testkmm10.data.remote.TKClient
import com.arstagaev.testkmm10.data.remote.createHttpClient
import com.arstagaev.testkmm10.data.repository.AnimeRepositoryImpl
import com.arstagaev.testkmm10.domain.interactor.GetWeatherByCityUseCase
import com.arstagaev.testkmm10.domain.repository.IAnimeRepository
import com.arstagaev.testkmm10.util.provideDispatcher
import org.koin.core.module.Module
import org.koin.dsl.module

private val dataModule = module {
    single { createHttpClient(true) }
    single { TKClient(client = get()) }

    single {
        RemoteDataSource(get(),get())
    }
    factory { AnimeApi() }
}
private val utilityModule = module {
    factory {
        provideDispatcher()
    }
}

private val domainModule = module {
    single<IAnimeRepository> {
        AnimeRepositoryImpl()
    }
    factory { GetWeatherByCityUseCase() }
    //factory { GetCharacterByIdUseCase() }
}
val sharedModules = listOf(dataModule, utilityModule, domainModule)