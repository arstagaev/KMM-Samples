package com.arstagaev.testkmm10.android.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arstagaev.testkmm10.domain.interactor.GetWeatherByCityUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val useCase: GetWeatherByCityUseCase,
    name: String
): ViewModel() {
    private val _uiState: MutableStateFlow<DetailState> = MutableStateFlow(DetailState())
    val uiState: StateFlow<DetailState> get() = _uiState

    init {
        getCharacterById(name)
    }
    private fun getCharacterById(name: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            delay(300L)
            try {
                 _uiState.value = _uiState.value.copy(success = useCase(name), isLoading = false)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(isLoading = false, error = e.message.toString())
            }
        }
    }
}