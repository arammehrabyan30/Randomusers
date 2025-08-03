package com.aram.mehrabyan.network.internal.converter

import retrofit2.Converter

internal interface ConverterFactoryProvider {

    fun provide(): Converter.Factory
}