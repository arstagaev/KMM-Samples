package com.arstagaev.testkmm10.domain.repository

import com.arstagaev.testkmm10.domain.model.Weather

interface IWeatherRepository {
    suspend fun getWeatherByCity(cityName: String): Weather
}