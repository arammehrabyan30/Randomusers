package com.aram.mehrabyan.users.impl.internal.userItems.manager

import com.aram.mehrabyan.core.coroutines.AppDispatchers
import com.aram.mehrabyan.users.impl.internal.data.UsersRepo
import com.aram.mehrabyan.users.impl.internal.data.mapper.UserUiModelToDBModelMapper
import com.aram.mehrabyan.users.impl.internal.userItems.adapter.UserItemUiModel
import kotlinx.coroutines.withContext

internal class RealBookmarksManager(
    private val usersRepo: UsersRepo,
    private val mapper: UserUiModelToDBModelMapper,
    private val dispatchers: AppDispatchers
) : BookmarksManager {

    override suspend fun bookmarkUser(item: UserItemUiModel) {
        withContext(dispatchers.ioDispatcher) {
            usersRepo.bookmarkUser(mapper.map(item))
        }
    }

    override suspend fun deleteBookmarkedUser(item: UserItemUiModel) {
        withContext(dispatchers.ioDispatcher) {
            usersRepo.deleteBookmarkedUser(mapper.map(item))
        }
    }
}