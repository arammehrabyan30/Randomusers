package com.aram.mehrabyan.users.impl.internal.userItems.randomUsers.ui

import com.aram.mehrabyan.users.impl.internal.userItems.adapter.UserItemUiModel

internal data class RandomUsersUiData(
    val items: List<UserItemUiModel>,
    val currentPage: Int?,
    val hasNextPage: Boolean = true
) {
    companion object {
        const val INITIAL_PAGE = 0
        const val PAGE_LIMIT = 25
    }
}