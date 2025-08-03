package com.aram.mehrabyan.network.internal

import com.aram.mehrabyan.network.api.RestApiCreator
import com.aram.mehrabyan.network.internal.retrofit.RetrofitCreator

internal class RealRestApiCreator(
    private val retrofitCreator: RetrofitCreator
) : RestApiCreator {

    override fun <API_SERVICE_INTERFACE> createApiService(
        apiClass: Class<API_SERVICE_INTERFACE>
    ): API_SERVICE_INTERFACE {
        return retrofitCreator.create().create(apiClass)
    }
}