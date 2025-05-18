package com.github.reyst.kmp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.reyst.kmp.network.NetworkService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val service: NetworkService,
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        UiState(
            fetchData = ::fetchData,
        )
    )
    val uiState = _uiState.asStateFlow()

    private fun fetchData() {
        viewModelScope.launch {
            service.fetchData()
                .also { text ->
                    _uiState.update {
                        it.copy(text = text)
                    }
                }
        }
    }
}

data class UiState(
    val text: String = "",

    val fetchData: () -> Unit = {},
)