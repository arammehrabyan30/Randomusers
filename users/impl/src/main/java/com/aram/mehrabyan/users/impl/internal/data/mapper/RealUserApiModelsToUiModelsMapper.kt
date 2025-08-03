package com.aram.mehrabyan.users.impl.internal.data.mapper

import com.aram.mehrabyan.db.api.UserItemEntity
import com.aram.mehrabyan.users.impl.internal.data.entity.UserApiModel
import com.aram.mehrabyan.users.impl.internal.userItems.adapter.UserItemUiModel
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone
import java.util.UUID

internal class RealUserApiModelsToUiModelsMapper : UserApiModelsToUiModelsMapper {

    override fun map(
        items: List<UserApiModel>?,
        bookMarkedItems: List<UserItemEntity>?
    ): List<UserItemUiModel> {
        return items?.map { item ->
            map(item = item, bookMarkedItems = bookMarkedItems)
        }.orEmpty()
    }

    private fun map(
        item: UserApiModel,
        bookMarkedItems: List<UserItemEntity>?
    ): UserItemUiModel {
        val id = item.id.value ?: item.email ?: UUID.randomUUID().toString()
        return UserItemUiModel(
            id = id,
            age = item.dob?.age ?: 0,
            name = item.name?.firstName.orEmpty() + item.name?.lastName.orEmpty(),
            email = item.email.orEmpty(),
            phone = item.phone.orEmpty(),
            birthDate = formatLegacyDate(item.dob?.date),
            country = item.location?.country.orEmpty(),
            state = item.location?.state.orEmpty(),
            city = item.location?.city.orEmpty(),
            street = item.location?.street?.name.orEmpty(),
            thumbnail = item.picture?.thumbnail.orEmpty(),
            imageUrl = item.picture?.largeImage.orEmpty(),
            isBookMarked = isBookMarked(id = id, bookMarkedItems = bookMarkedItems)
        )
    }

    private fun isBookMarked(id: String?, bookMarkedItems: List<UserItemEntity>?): Boolean {
        return bookMarkedItems?.any { it.id == id } ?: false
    }

    private fun formatLegacyDate(dateString: String?): String {
        return dateString?.let {
            val inputFormat = SimpleDateFormat(INPUT_DATA_FORMAT_PATTERN, Locale.ENGLISH)
            inputFormat.timeZone = TimeZone.getTimeZone(TIME_ZONE_ID)

            inputFormat.parse(it)?.let { date ->
                val outputFormat = SimpleDateFormat(OUTPUT_DATA_FORMAT_PATTERN, Locale.ENGLISH)
                outputFormat.format(date)
            }
        }.orEmpty()
    }

    companion object {
        private const val TIME_ZONE_ID = "UTC"
        private const val INPUT_DATA_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
        private const val OUTPUT_DATA_FORMAT_PATTERN = "MMM d, yyyy"
    }
}