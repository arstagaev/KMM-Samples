package com.arstagaev.testkmm10

import app.cash.sqldelight.db.SqlDriver
import com.arstagaev.testkmm10.cache.WeatherDatabase
import org.koin.core.scope.Scope

expect fun Scope.sqlDriverFactory(): SqlDriver

fun createDatabase(driver: SqlDriver): WeatherDatabase {
    return WeatherDatabase(driver = driver)
}