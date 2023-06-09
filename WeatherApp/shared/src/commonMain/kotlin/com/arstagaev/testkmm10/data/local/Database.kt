package com.arstagaev.testkmm10.data.local

import com.arstagaev.testkmm10.DatabaseDriverFactory
import com.arstagaev.testkmm10.cache.AppDatabase
import com.arstagaev.testkmm10.data.local.models.WeatherCache

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun clearDatabase() {
        dbQuery.transaction {
            dbQuery.removeAllLaunches()
        }
    }

    internal fun getAllLaunches(): List<WeatherCache> {
        return dbQuery.selectAllLaunchesInfo(::mapWeather).executeAsList()
    }

    private fun mapWeather(
        cityName: String,
        temp: String
    ): WeatherCache {
        return WeatherCache(
            cityName = cityName,
            temp = temp
        )
    }

    internal fun createLaunches(launches: List<WeatherCache>) {
        dbQuery.transaction {
            launches.forEach { launch ->
                insertLaunch(launch)
            }
        }
    }

    private fun insertLaunch(wc: WeatherCache) {
        dbQuery.insertLaunch(
            cityName = wc.cityName,
            temp = wc.temp
        )
    }
}
