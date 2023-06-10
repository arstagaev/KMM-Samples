package com.arstagaev.testkmm10.data.local

import com.arstagaev.testkmm10.cache.WeatherDatabase
import com.arstagaev.testkmm10.data.local.models.WeatherCacheEntity
import com.arstagaev.testkmm10.provideDispatcher
import kotlinx.coroutines.withContext

class WeatherDao(
    private val weatherDatabase: WeatherDatabase
) {
    private val query get() = weatherDatabase.weatherEntityQueries

    suspend fun selectAllByPage() = query.selectAllCityInfo().executeAsList()

    suspend fun insert(weatherEntity: WeatherCacheEntity) = withContext(provideDispatcher.io) {
        query.insertCity(cityName = weatherEntity.cityName, temp = weatherEntity.temp)
    }
}
