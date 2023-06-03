package com.arstagaev.testkmm10.domain.repository

import com.arstagaev.testkmm10.domain.model.Weather

interface IWeatherRepository {
//    suspend fun getAllCharacters(): List<Anime>
//    suspend fun getCharacterById(id: Int): Anime

    suspend fun getWeatherByCity(cityName: String): Weather
}