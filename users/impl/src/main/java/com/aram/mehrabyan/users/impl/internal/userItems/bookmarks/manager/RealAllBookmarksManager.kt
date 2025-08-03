package com.aram.mehrabyan.users.impl.internal.userItems.bookmarks.manager

import com.aram.mehrabyan.core.coroutines.AppDispatchers
import com.aram.mehrabyan.users.impl.internal.data.UsersRepo
import com.aram.mehrabyan.users.impl.internal.data.mapper.UserDBModelsToUiModelsMapper
import com.aram.mehrabyan.users.impl.internal.userItems.adapter.UserItemUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

internal class RealAllBookmarksManager(
    private val usersRepo: UsersRepo,
    private val mapper: UserDBModelsToUiModelsMapper,
    private val dispatchers: AppDispatchers
) : AllBookmarksManager {

    override fun getAllBookmarkedUsers(): Flow<List<UserItemUiModel>> {
        return usersRepo.getAllBookmarkedUsers().map { items ->
            mapper.map(items)
        }.flowOn(dispatchers.ioDispatcher)
    }
}