package com.aram.mehrabyan.db.api

import kotlinx.coroutines.flow.Flow

interface LocalUserItemsService {

    suspend fun insert(item: UserItemEntity)

    suspend fun delete(item: UserItemEntity)

    fun getAll(): Flow<List<UserItemEntity>>
}