package com.arstagaev.testkmm10.data.remote

import com.arstagaev.testkmm10.util.Dispatcher
import kotlinx.coroutines.withContext

internal class RemoteDataSource(
    private val api: AnimeApi,
    private val dispatcher: Dispatcher
) {
//    suspend fun getAllCharacters() = withContext(dispatcher.io) {
//        api.getAllCharacters()
//    }
    suspend fun getWeatherByCity(cityName: String) = withContext(dispatcher.io) {
        api.getWeatherByCity(cityName)
    }
//    suspend fun getCharacterById(id: Int) = withContext(dispatcher.io) {
//        api.getCharacterById(id)
//    }
}