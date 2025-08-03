package com.aram.mehrabyan.network.api

sealed interface ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>

    sealed interface Error : ApiResult<Nothing> {
        data class ApiError(val code: Int, val message: String?) : Error
        data class NetworkError(val exception: Throwable) : Error
    }
}