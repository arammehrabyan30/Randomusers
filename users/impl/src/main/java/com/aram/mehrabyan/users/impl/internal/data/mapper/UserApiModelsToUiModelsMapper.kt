package com.aram.mehrabyan.users.impl.internal.data.mapper

import com.aram.mehrabyan.db.api.UserItemEntity
import com.aram.mehrabyan.users.impl.internal.data.entity.UserApiModel
import com.aram.mehrabyan.users.impl.internal.userItems.adapter.UserItemUiModel

internal interface UserApiModelsToUiModelsMapper {

    fun map(
        items: List<UserApiModel>?,
        bookMarkedItems: List<UserItemEntity>?
    ): List<UserItemUiModel>
}