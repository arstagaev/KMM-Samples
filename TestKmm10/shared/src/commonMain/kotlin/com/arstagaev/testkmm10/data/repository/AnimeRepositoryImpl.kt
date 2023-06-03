package com.arstagaev.testkmm10.data.repository

import com.arstagaev.testkmm10.data.mapper.prepareToUI
import com.arstagaev.testkmm10.data.remote.RemoteDataSource
import com.arstagaev.testkmm10.data.remote.TKClient
import com.arstagaev.testkmm10.data.remote.models.WeatherDto
import com.arstagaev.testkmm10.domain.model.Anime
import com.arstagaev.testkmm10.domain.model.Weather
import com.arstagaev.testkmm10.domain.repository.IAnimeRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class AnimeRepositoryImpl(
): IAnimeRepository, KoinComponent {
    private val tkClient by inject<TKClient>()

    override suspend fun getWeatherByCity(cityName: String): Weather {
        println("request:::: ${cityName}")
        return tkClient.getWeatherByCity(cityName).prepareToUI()
    }
}
