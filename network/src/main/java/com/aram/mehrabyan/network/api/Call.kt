package com.aram.mehrabyan.network.api

import retrofit2.Response

suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): ApiResult<T> {
    return try {
        val response = apiCall()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                ApiResult.Success(body)
            } else {
                ApiResult.Error.ApiError(response.code(), "Empty body")
            }
        } else {
            ApiResult.Error.ApiError(response.code(), response.errorBody()?.string())
        }
    } catch (e: Exception) {
        ApiResult.Error.NetworkError(e)
    }
}