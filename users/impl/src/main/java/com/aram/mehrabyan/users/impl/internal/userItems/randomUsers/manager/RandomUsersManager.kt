package com.aram.mehrabyan.users.impl.internal.userItems.randomUsers.manager

import com.aram.mehrabyan.core.data.ActionResult
import com.aram.mehrabyan.db.api.UserItemEntity
import com.aram.mehrabyan.users.impl.internal.userItems.randomUsers.ui.RandomUsersUiData
import kotlinx.coroutines.flow.Flow

internal interface RandomUsersManager {

    suspend fun getRandomUsers(
        loadedItems: RandomUsersUiData?
    ): ActionResult<RandomUsersUiData>

    fun getAllBookmarkedUsers(): Flow<List<UserItemEntity>>

    fun handleDataWithBookmarks(
        loadedItems: RandomUsersUiData,
        bookmarks: List<UserItemEntity>
    ): RandomUsersUiData
}