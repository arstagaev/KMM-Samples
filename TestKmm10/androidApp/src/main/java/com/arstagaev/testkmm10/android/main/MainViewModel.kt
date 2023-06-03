package com.arstagaev.testkmm10.android.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arstagaev.testkmm10.domain.interactor.GetWeatherByCityUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val useCase: GetWeatherByCityUseCase
): ViewModel() {
    private val _uiState: MutableStateFlow<MainState> = MutableStateFlow(MainState())
    val uiState: StateFlow<MainState> get() = _uiState
    init {
        getAllCharacters(name= "Saratov")
    }
    private fun getAllCharacters(name: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                val response = useCase
                _uiState.value = _uiState.value.copy(isLoading = false, success = response.invoke(name))
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = e.message.toString(), isLoading = false)
            }
        }
    }
}