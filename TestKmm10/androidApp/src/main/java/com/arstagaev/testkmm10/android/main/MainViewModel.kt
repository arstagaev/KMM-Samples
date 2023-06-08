package com.arstagaev.testkmm10.android.main

import android.R.attr.country
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arstagaev.testkmm10.domain.interactor.GetWeatherByCityUseCase
import com.arstagaev.testkmm10.util.MainState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.Locale


class MainViewModel(
    private val useCase: GetWeatherByCityUseCase
): ViewModel() {
    private val _uiState: MutableStateFlow<MainState?> = MutableStateFlow(MainState())
    val uiState: StateFlow<MainState?> get() = _uiState

    var cityName = mutableStateOf(TextFieldValue())

    init {
        getAllCharacters(name= "Marcel")
    }
    fun getAllCharacters(name: String = cityName.value.text) {
        println("request name: $name")
        viewModelScope.launch {
            _uiState.value = _uiState.value?.copy(isLoading = true)
            try {
                _uiState.value = _uiState.value?.copy(isLoading = false, success = useCase.invoke(name), error = null)
                val obj = Locale("", _uiState.value?.success?.country)

            } catch (e: Exception) {
                _uiState.value = _uiState.value?.copy(error = e.message.toString(), isLoading = false)
            }
        }
    }
}