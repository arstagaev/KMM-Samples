package com.arstagaev.testkmm10.util

import com.arstagaev.testkmm10.domain.model.Weather

data class MainState (
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: Weather? = null
)