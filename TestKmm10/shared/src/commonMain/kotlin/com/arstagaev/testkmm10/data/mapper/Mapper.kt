package com.arstagaev.testkmm10.data.mapper

import com.arstagaev.testkmm10.data.remote.models.Condition
import com.arstagaev.testkmm10.data.remote.models.WeatherDto
import com.arstagaev.testkmm10.domain.model.Weather
import com.arstagaev.testkmm10.extensions.withHttps

fun WeatherDto.prepareToUI(): Weather {
    return Weather(
        name = location.name,
        country = location.country,
        lat = location.lat,
        lon = location.lon,
        localtime = location.localtime,
        region = location.region,
        cloud = current.cloud,
        condition = Condition(
            current.condition.code,
            current.condition.icon.withHttps(),
            current.condition.text
        ),
        feelslike_c = current.feelslike_c
    )
}