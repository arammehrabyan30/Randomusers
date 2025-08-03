package com.aram.mehrabyan.network.internal.retrofit

import retrofit2.Retrofit

internal interface RetrofitCreator {

    fun create(): Retrofit
}