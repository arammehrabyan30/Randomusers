package com.aram.mehrabyan.users.impl.internal.userItems.bookmarks.manager

import com.aram.mehrabyan.users.impl.internal.userItems.adapter.UserItemUiModel
import kotlinx.coroutines.flow.Flow

internal interface AllBookmarksManager {

    fun getAllBookmarkedUsers(): Flow<List<UserItemUiModel>>
}