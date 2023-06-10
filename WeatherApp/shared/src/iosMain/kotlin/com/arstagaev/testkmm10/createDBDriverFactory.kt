package com.arstagaev.testkmm10

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.arstagaev.testkmm10.cache.WeatherDatabase
import com.arstagaev.testkmm10.util.Constants.nameDB
import org.koin.core.scope.Scope


actual fun Scope.sqlDriverFactory(): SqlDriver {
    return NativeSqliteDriver(WeatherDatabase.Schema,"${nameDB}.db")
}