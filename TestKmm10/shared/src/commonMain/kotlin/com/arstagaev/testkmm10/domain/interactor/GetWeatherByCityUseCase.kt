package com.arstagaev.testkmm10.domain.interactor

import com.arstagaev.testkmm10.domain.model.Anime
import com.arstagaev.testkmm10.domain.model.Weather
import com.arstagaev.testkmm10.domain.repository.IAnimeRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetWeatherByCityUseCase: KoinComponent, BaseUseCase<String,Weather> {
    private val repository: IAnimeRepository by inject()
    override suspend fun invoke(cityName: String): Weather {
        return repository.getWeatherByCity(cityName)
    }
}

//class GetAllCharactersUseCase: KoinComponent, ReceiverUseCase<List<Anime>> {
//    private val repository: IAnimeRepository by inject()
//    override suspend fun invoke(): List<Anime> {
//        return repository.getAllCharacters()
//    }
//}