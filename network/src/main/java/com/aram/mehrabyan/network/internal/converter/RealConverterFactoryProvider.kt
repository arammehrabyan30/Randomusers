package com.aram.mehrabyan.network.internal.converter

import com.google.gson.GsonBuilder
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

internal class RealConverterFactoryProvider: ConverterFactoryProvider {

    override fun provide(): Converter.Factory {
        return GsonConverterFactory.create(GsonBuilder().create())
    }
}