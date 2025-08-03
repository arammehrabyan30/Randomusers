package com.aram.mehrabyan.users.impl.internal.userItems.manager

import com.aram.mehrabyan.users.impl.internal.userItems.adapter.UserItemUiModel

internal interface BookmarksManager {

    suspend fun bookmarkUser(item: UserItemUiModel)

    suspend fun deleteBookmarkedUser(item: UserItemUiModel)
}