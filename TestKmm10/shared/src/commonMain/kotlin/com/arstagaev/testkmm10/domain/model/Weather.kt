package com.arstagaev.testkmm10.domain.model

import com.arstagaev.testkmm10.data.remote.models.Condition

data class Weather(
    val country: String,
    val lat: Double,
    val localtime: String,
    val lon: Double,
    val name: String,
    val region: String,

    val cloud: Int,
    val condition: String,
    val feelslike_c: Double,
)
