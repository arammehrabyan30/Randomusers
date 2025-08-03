package com.aram.mehrabyan.users.impl.internal.data

import com.aram.mehrabyan.users.impl.internal.data.entity.RandomUsersApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface UsersApiService {

    @GET("api")
    suspend fun getRandomUsers(
        @Query("page") page: Int,
        @Query("results") limit: Int
    ): Response<RandomUsersApiModel>
}