package com.arstagaev.testkmm10.repository

import com.arstagaev.testkmm10.domain.model.Weather

interface IWeatherRepository {
    suspend fun getWeatherByCity(cityName: String): Weather
}