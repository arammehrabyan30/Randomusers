package com.aram.mehrabyan.core.ui

sealed interface UiState<out T> {
    data class Success<T>(val data: T) : UiState<T>

    data class Error(val exception: Throwable? = null) : UiState<Nothing>

    sealed interface Loading<T> : UiState<T> {
        data object PageLoading : Loading<Nothing>

        data class NextPageLoading<T>(val data: T) : Loading<T>
    }

    data object Initial : UiState<Nothing>
}
