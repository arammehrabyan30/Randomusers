package com.aram.mehrabyan.network.di

import com.aram.mehrabyan.network.api.RestApiCreator
import com.aram.mehrabyan.network.internal.RealRestApiCreator
import com.aram.mehrabyan.network.internal.client.ClientProvider
import com.aram.mehrabyan.network.internal.client.RealClientProvider
import com.aram.mehrabyan.network.internal.converter.ConverterFactoryProvider
import com.aram.mehrabyan.network.internal.converter.RealConverterFactoryProvider
import com.aram.mehrabyan.network.internal.retrofit.RealRetrofitCreator
import com.aram.mehrabyan.network.internal.retrofit.RetrofitCreator
import org.koin.dsl.module

fun networkModule() = module {
    single<ConverterFactoryProvider> {
        RealConverterFactoryProvider()
    }

    single<ClientProvider> {
        RealClientProvider()
    }

    single<RetrofitCreator> {
        RealRetrofitCreator(converterFactoryProvider = get(), clientProvider = get())
    }

    single<RestApiCreator> {
        RealRestApiCreator(retrofitCreator = get())
    }
}