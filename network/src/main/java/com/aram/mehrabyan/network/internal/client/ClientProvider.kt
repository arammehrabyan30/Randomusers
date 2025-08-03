package com.aram.mehrabyan.network.internal.client

import okhttp3.OkHttpClient

internal interface ClientProvider {

    fun provide(): OkHttpClient
}