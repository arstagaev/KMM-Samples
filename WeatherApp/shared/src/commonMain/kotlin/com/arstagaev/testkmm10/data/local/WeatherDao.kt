package com.arstagaev.testkmm10.data.local

import com.arstagaev.testkmm10.cache.Cityw
import com.arstagaev.testkmm10.cache.WeatherDatabase
import com.arstagaev.testkmm10.provideDispatcher
import kotlinx.coroutines.withContext

class WeatherDao(
    private val weatherDatabase: WeatherDatabase
) {
    private val query get() = weatherDatabase.weatherDatabaseQueries

    suspend fun selectAllByPage() = query.selectAllCityInfo().executeAsList()

    suspend fun insert(weatherEntity: Cityw) {
       query.insertCity(weatherEntity.cityName,weatherEntity.lastUpd)
    }
}
