package com.aram.mehrabyan.users.impl.internal.data.entity

import com.google.gson.annotations.SerializedName

internal data class RandomUsersApiModel(
    @SerializedName("results") val results: List<UserApiModel>?,
    @SerializedName("info") val loadInfo: LoadInfo?
)

internal data class UserApiModel(
    @SerializedName("id") val id: Id,
    @SerializedName("name") val name: Name?,
    @SerializedName("dob") val dob: DOB?,
    @SerializedName("picture") val picture: Picture?,
    @SerializedName("location") val location: Location?,
    @SerializedName("email") val email: String?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("nat") val nationality: String?,
) {
    data class Id(@SerializedName("value") val value: String?)

    data class Name(
        @SerializedName("title") val title: String?,
        @SerializedName("first") val firstName: String?,
        @SerializedName("last") val lastName: String?
    )

    data class DOB(
        @SerializedName("date") val date: String?,
        @SerializedName("age") val age: Int
    )

    data class Picture(
        @SerializedName("large") val largeImage: String?,
        @SerializedName("thumbnail") val thumbnail: String?
    )

    data class Location(
        @SerializedName("street") val street: Street?,
        @SerializedName("city") val city: String?,
        @SerializedName("state") val state: String?,
        @SerializedName("country") val country: String?
    ) {
        data class Street(@SerializedName("name") val name: String)
    }
}

internal data class LoadInfo(
    @SerializedName("page") val page: Int
)
