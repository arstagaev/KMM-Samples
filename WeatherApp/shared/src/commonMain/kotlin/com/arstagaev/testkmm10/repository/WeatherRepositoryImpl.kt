package com.arstagaev.testkmm10.repository

import com.arstagaev.testkmm10.cache.Cityw
import com.arstagaev.testkmm10.data.local.WeatherDao
import com.arstagaev.testkmm10.data.mapper.prepareToUI
import com.arstagaev.testkmm10.data.remote.WeatherClient
import com.arstagaev.testkmm10.domain.model.Weather
import com.arstagaev.testkmm10.util.DateTimeUtil
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.time.TimedValue

internal class WeatherRepositoryImpl(
): IWeatherRepository, KoinComponent {

    private val weatherClient by inject<WeatherClient>()
    private val weatherDao by inject<WeatherDao>()

    override suspend fun getWeatherByCity(cityName: String): Weather {
        weatherDao.insert(Cityw(cityName,"${DateTimeUtil.nowTime()}"))
        return weatherClient.getWeatherByCity(cityName).prepareToUI()
    }


}
