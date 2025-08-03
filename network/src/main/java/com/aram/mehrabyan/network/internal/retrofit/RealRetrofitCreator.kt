package com.aram.mehrabyan.network.internal.retrofit

import com.aram.mehrabyan.network.internal.client.ClientProvider
import com.aram.mehrabyan.network.internal.converter.ConverterFactoryProvider
import retrofit2.Retrofit

internal class RealRetrofitCreator(
    private val converterFactoryProvider: ConverterFactoryProvider,
    private val clientProvider: ClientProvider
) : RetrofitCreator {

    override fun create(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(clientProvider.provide())
            .addConverterFactory(converterFactoryProvider.provide())
            .build()
    }

    companion object {
        private const val BASE_URL = "https://randomuser.me/"
    }
}