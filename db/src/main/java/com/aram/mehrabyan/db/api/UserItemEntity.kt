package com.aram.mehrabyan.db.api

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_item")
data class UserItemEntity(
    @PrimaryKey val id: String,
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
    val imageUrl: String?
)
