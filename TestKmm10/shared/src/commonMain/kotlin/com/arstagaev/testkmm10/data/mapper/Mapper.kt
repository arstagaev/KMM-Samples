package com.arstagaev.testkmm10.data.mapper

import com.arstagaev.testkmm10.data.remote.models.Condition
import com.arstagaev.testkmm10.data.remote.models.WeatherDto
import com.arstagaev.testkmm10.domain.model.Weather

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
            "https:"+current.condition.icon,
            current.condition.text
        ),
        feelslike_c = current.feelslike_c
    )
}