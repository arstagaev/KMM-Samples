package com.arstagaev.testkmm10.repository

import com.arstagaev.testkmm10.data.local.WeatherDao
import com.arstagaev.testkmm10.data.local.models.WeatherCacheEntity
import com.arstagaev.testkmm10.data.mapper.prepareToUI
import com.arstagaev.testkmm10.data.remote.WeatherClient
import com.arstagaev.testkmm10.domain.model.Weather
import com.arstagaev.testkmm10.repository.IWeatherRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class WeatherRepositoryImpl(
): IWeatherRepository, KoinComponent {
    private val weatherClient by inject<WeatherClient>()
    private val weatherDao by inject<WeatherDao>()

    override suspend fun getWeatherByCity(cityName: String): Weather {
        weatherDao.insert(WeatherCacheEntity(cityName,"0+"))

        println(">>>> ${weatherDao.selectAllByPage()}")

        return weatherClient.getWeatherByCity(cityName).prepareToUI()
    }


}
