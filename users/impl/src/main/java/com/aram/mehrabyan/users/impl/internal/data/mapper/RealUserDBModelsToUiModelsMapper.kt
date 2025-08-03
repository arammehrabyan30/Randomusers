package com.aram.mehrabyan.users.impl.internal.data.mapper

import com.aram.mehrabyan.db.api.UserItemEntity
import com.aram.mehrabyan.users.impl.internal.userItems.adapter.UserItemUiModel

internal class RealUserDBModelsToUiModelsMapper : UserDBModelsToUiModelsMapper {

    override fun map(bookMarkedItems: List<UserItemEntity>): List<UserItemUiModel> {
        return bookMarkedItems.map { item -> map(item = item) }
    }

    private fun map(item: UserItemEntity): UserItemUiModel {
        return UserItemUiModel(
            id = item.id,
            age = item.age,
            name = item.name,
            email = item.email,
            phone = item.phone,
            birthDate = item.birthDate,
            country = item.country,
            state = item.state,
            city = item.city,
            street = item.street,
            thumbnail = item.thumbnail,
            imageUrl = item.imageUrl,
            isBookMarked = true
        )
    }
}