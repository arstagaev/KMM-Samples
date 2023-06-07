package com.arstagaev.testkmm10.util

import com.arstagaev.testkmm10.domain.model.Weather


//sealed class MainState {
////    object isLoading : MainState()
////    data class Success(val weather: Weather? = null) : MainState()
////    data class Error(val errorMessage: String? = null) : MainState()
//
//
//   val isLoading: Boolean = false
//   val error: String? = null
//   val success: Weather? = null
//}

data class MainState (
//    object isLoading : MainState()
//    data class Success(val weather: Weather? = null) : MainState()
//    data class Error(val errorMessage: String? = null) : MainState()


    val isLoading: Boolean = false,
    val error: String? = null,
    val success: Weather? = null
)