package com.aram.mehrabyan.users.impl.internal.data

import com.aram.mehrabyan.db.api.UserItemEntity
import com.aram.mehrabyan.network.api.ApiResult
import com.aram.mehrabyan.users.impl.internal.data.entity.RandomUsersApiModel
import kotlinx.coroutines.flow.Flow

internal interface UsersRepo {

    suspend fun getRandomUsers(page: Int, limit: Int): ApiResult<RandomUsersApiModel>

    suspend fun bookmarkUser(item: UserItemEntity)

    suspend fun deleteBookmarkedUser(item: UserItemEntity)

    fun getAllBookmarkedUsers(): Flow<List<UserItemEntity>>
}