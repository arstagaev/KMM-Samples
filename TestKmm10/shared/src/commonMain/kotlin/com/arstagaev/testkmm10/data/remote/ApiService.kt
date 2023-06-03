package com.arstagaev.testkmm10.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal abstract class ApiService {
    val client = HttpClient {

        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = false
                useAlternativeNames = false
            })
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }
}

