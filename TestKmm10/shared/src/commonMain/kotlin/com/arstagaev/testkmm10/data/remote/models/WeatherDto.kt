package com.arstagaev.testkmm10.data.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class WeatherDto(
    val current: Current,
    val location: Location
)