package com.aram.mehrabyan.users.impl.internal.data

import com.aram.mehrabyan.db.api.LocalUserItemsService
import com.aram.mehrabyan.db.api.UserItemEntity
import com.aram.mehrabyan.network.api.ApiResult
import com.aram.mehrabyan.network.api.safeApiCall
import com.aram.mehrabyan.users.impl.internal.data.entity.RandomUsersApiModel
import kotlinx.coroutines.flow.Flow

internal class RealUsersRepo(
    private val localUsersService: LocalUserItemsService,
    private val apiUsersService: UsersApiService
) : UsersRepo {

    override suspend fun getRandomUsers(page: Int, limit: Int): ApiResult<RandomUsersApiModel> {
        return safeApiCall { apiUsersService.getRandomUsers(page = page, limit = limit) }
    }

    override suspend fun bookmarkUser(item: UserItemEntity) {
        localUsersService.insert(item = item)
    }

    override suspend fun deleteBookmarkedUser(item: UserItemEntity) {
        localUsersService.delete(item = item)
    }

    override fun getAllBookmarkedUsers(): Flow<List<UserItemEntity>> {
        return localUsersService.getAll()
    }
}