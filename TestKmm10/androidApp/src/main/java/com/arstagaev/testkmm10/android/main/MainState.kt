package com.arstagaev.testkmm10.android.main

import com.arstagaev.testkmm10.domain.model.Anime
import com.arstagaev.testkmm10.domain.model.Weather


data class MainState(
    val isLoading: Boolean = false,
    val error: String = "",
    val success: Weather? = null
)