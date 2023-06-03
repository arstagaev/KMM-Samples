package com.arstagaev.testkmm10.data.remote

object NetworkConstants {
    const val baseUrl1 = "https://api.weatherapi.com/v1/current.json?"
    const val apiKey = "038b220f8d1d443799f162217230306"

    //https://api.weatherapi.com/v1/current.json?key=038b220f8d1d443799f162217230306&q=Saratov&aqi=no
    object City {
        const val route = baseUrl1 + "key=${apiKey}&q="
        val byName: (String) -> String = { name -> "$route$name&aqi=no"}
    }

    //https://collectionapi.metmuseum.org/public/collection/v1/objects/327161
//    object Object {
//        const val route = baseUrl1 + "public/collection/v1/objects/"
//        val byIds: (String) -> String = { name -> "$route$name"}
//    }
}