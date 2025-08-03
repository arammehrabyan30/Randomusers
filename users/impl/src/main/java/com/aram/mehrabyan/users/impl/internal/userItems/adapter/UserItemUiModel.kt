package com.aram.mehrabyan.users.impl.internal.userItems.adapter

internal data class UserItemUiModel(
    val id: String,
    val age: Int,
    val name: String,
    val email: String,
    val phone: String,
    val birthDate: String,
    val country: String,
    val state: String,
    val city: String,
    val street: String,
    val thumbnail: String?,
    val imageUrl: String?,
    val isBookMarked: Boolean
)
