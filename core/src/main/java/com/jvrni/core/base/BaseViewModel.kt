package com.jvrni.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jvrni.core.State
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


abstract class BaseViewModel : ViewModel() {
    protected val _uiState = MutableStateFlow<ViewState?>(null)
    val uiState = _uiState.asStateFlow()
    var singleEmit = false

    fun <T> Flow<State<T>>.result(result: (T) -> Unit) {
        viewModelScope.launch {
            this@result.collect { state ->
                when (state) {
                    is State.Success -> result.invoke(state.data)
                    is State.Loading -> if (!singleEmit) {
                        _uiState.update { ViewState.Loading }
                        singleEmit = true
                    }
                    else -> {
                        _uiState.update { ViewState.Error }
                        singleEmit = true
                    }
                }
            }
        }
    }
}