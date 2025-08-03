package com.aram.mehrabyan.users.impl.internal.data.mapper

import com.aram.mehrabyan.db.api.UserItemEntity
import com.aram.mehrabyan.users.impl.internal.userItems.adapter.UserItemUiModel

internal interface UserDBModelsToUiModelsMapper {

    fun map(bookMarkedItems: List<UserItemEntity>): List<UserItemUiModel>
}