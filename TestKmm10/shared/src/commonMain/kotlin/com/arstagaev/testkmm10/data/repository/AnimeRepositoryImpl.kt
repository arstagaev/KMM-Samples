package com.arstagaev.testkmm10.data.repository

import com.arstagaev.testkmm10.data.mapper.prepareToUI
import com.arstagaev.testkmm10.data.remote.TKClient
import com.arstagaev.testkmm10.domain.model.Weather
import com.arstagaev.testkmm10.domain.repository.IWeatherRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class AnimeRepositoryImpl(
): IWeatherRepository, KoinComponent {
    private val tkClient by inject<TKClient>()

    override suspend fun getWeatherByCity(cityName: String): Weather {
        println("request:::: ${cityName}")
        return tkClient.getWeatherByCity(cityName).prepareToUI()
    }
}
