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

    suspend fun getWeatherByCity(cityName: String): WeatherDto {
        //val client = ApiService()
        var address = "$BASE_URL2?key=$APIKEY&q=$cityName&aqi=no"
        println("request:::::2::::> $BASE_URL2?key=$APIKEY&q=$cityName&aqi=no")
        //val a = client.get("$BASE_URL2?key=$APIKEY&q=$cityName&aqi=no")
        println("pizzdec ${client.engine.config.toString()} ")
//        CoroutineScope(Dispatchers.Default).launch {
//
//        }
        var a = client.get("$BASE_URL2?key=$APIKEY&q=$cityName&aqi=no").body<WeatherDto>()
        println(":::3> $${a.toString()}")
        //address = "google.com"
        //println(":::>code ${a.status.value}")
        return a
    }

    companion object {
        //private const val PageSize = 20
    }

}