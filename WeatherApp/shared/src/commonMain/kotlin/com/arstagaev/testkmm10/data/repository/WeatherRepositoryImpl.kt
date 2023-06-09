package com.arstagaev.testkmm10.data.repository

import com.arstagaev.testkmm10.data.mapper.prepareToUI
import com.arstagaev.testkmm10.data.remote.WeatherClient
import com.arstagaev.testkmm10.domain.model.Weather
import com.arstagaev.testkmm10.domain.repository.IWeatherRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class WeatherRepositoryImpl(
): IWeatherRepository, KoinComponent {
    private val weatherClient by inject<WeatherClient>()

    override suspend fun getWeatherByCity(cityName: String): Weather = weatherClient.getWeatherByCity(cityName).prepareToUI()
}
