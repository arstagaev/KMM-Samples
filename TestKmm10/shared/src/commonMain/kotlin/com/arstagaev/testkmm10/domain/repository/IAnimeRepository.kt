package com.arstagaev.testkmm10.domain.repository

import com.arstagaev.testkmm10.domain.model.Anime
import com.arstagaev.testkmm10.domain.model.Weather

interface IAnimeRepository {
//    suspend fun getAllCharacters(): List<Anime>
//    suspend fun getCharacterById(id: Int): Anime

    suspend fun getWeatherByCity(cityName: String): Weather
}