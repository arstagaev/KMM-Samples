package com.arstagaev.testkmm10.data.remote

import com.arstagaev.testkmm10.data.remote.models.WeatherDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class WeatherClient(
    private val client: HttpClient
) {

    suspend fun getWeatherByCity(cityName: String): WeatherDto =
        client.get(NetworkConstants.City.byName(cityName)).body<WeatherDto>()

    companion object {
        //private const val PageSize = 20
    }

}