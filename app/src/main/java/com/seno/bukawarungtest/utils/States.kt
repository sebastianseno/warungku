package com.seno.bukawarungtest.utils

sealed class UiState {
    object Loading : UiState()
    object Success : UiState()
    object Finish : UiState()
    class Error(val message: String) : UiState()
}