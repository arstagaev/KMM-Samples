package com.arstagaev.testkmm10.data.remote

import com.arstagaev.testkmm10.data.remote.models.WeatherDto
import com.arstagaev.testkmm10.domain.model.Weather
import io.ktor.client.call.body
import io.ktor.client.request.get

const val BASE_URL = "https://api.jikan.moe/v4"
const val BASE_URL2 = "https://api.weatherapi.com/v1/current.json"
const val APIKEY = "038b220f8d1d443799f162217230306"

internal class AnimeApi: ApiService() {

//    suspend fun getAllCharacters(): AnimeDTO =
//        client.get("$BASE_URL/top/characters").body()
//
//    suspend fun getCharacterById(id: Int): DataResponse =
//        client.get("$BASE_URL/characters/$id").body()

    ////

    suspend fun getWeatherByCity(cityName: String): WeatherDto {
        //val client = ApiService()
        println("request:::::2::::> $BASE_URL2?key=$APIKEY&q=$cityName&aqi=no")
        val a = client.get("$BASE_URL2?key=$APIKEY&q=$cityName&aqi=no")

        println(":::> ${a.toString()}")
        println(":::>code ${a.status.value}")
        return client.get("$BASE_URL2?key=$APIKEY&q=$cityName&aqi=no").body<WeatherDto>()
    }

}