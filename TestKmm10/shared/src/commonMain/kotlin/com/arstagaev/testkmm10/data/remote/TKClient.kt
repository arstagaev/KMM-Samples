package com.arstagaev.testkmm10.data.remote

import com.arstagaev.testkmm10.data.remote.models.WeatherDto
import com.arstagaev.testkmm10.util.Dispatcher
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TKClient(
    private val client: HttpClient
) {

    suspend fun getWeatherByCity(cityName: String): WeatherDto =
        client.get(NetworkConstants.City.byName(cityName)).body<WeatherDto>()

    companion object {
        //private const val PageSize = 20
    }

}