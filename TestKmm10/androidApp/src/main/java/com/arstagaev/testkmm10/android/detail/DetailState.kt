package com.arstagaev.testkmm10.android.detail

import com.arstagaev.testkmm10.domain.model.Anime
import com.arstagaev.testkmm10.domain.model.Weather


data class DetailState(
    val isLoading: Boolean = false,
    val error: String = "",
    val success: Weather? = null
)