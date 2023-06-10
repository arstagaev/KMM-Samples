package com.arstagaev.testkmm10.di

import com.arstagaev.testkmm10.createDatabase
import com.arstagaev.testkmm10.data.local.WeatherDao
import com.arstagaev.testkmm10.data.remote.WeatherClient
import com.arstagaev.testkmm10.data.remote.createHttpClient
import com.arstagaev.testkmm10.repository.WeatherRepositoryImpl
import com.arstagaev.testkmm10.domain.interactor.GetWeatherByCityUseCase
import com.arstagaev.testkmm10.repository.IWeatherRepository
import com.arstagaev.testkmm10.provideDispatcher
import com.arstagaev.testkmm10.sqlDriverFactory
import org.koin.dsl.module

private val dataModule = module {
    single { createHttpClient(true) }
    single { WeatherClient(client = get()) }
}

private val dbModule = module {
    factory { sqlDriverFactory() }
    single { createDatabase(driver = get()) }
    single { WeatherDao(weatherDatabase = get()) }

}
private val utilityModule = module {
    factory { provideDispatcher }
}

private val domainModule = module {
    single<IWeatherRepository> {
        WeatherRepositoryImpl()
    }
    factory { GetWeatherByCityUseCase() }
}
val sharedModules = listOf(dataModule, utilityModule, domainModule, dbModule)