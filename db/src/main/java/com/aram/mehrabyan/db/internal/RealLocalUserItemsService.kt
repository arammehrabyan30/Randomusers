package com.aram.mehrabyan.db.internal

import com.aram.mehrabyan.core.coroutines.AppDispatchers
import com.aram.mehrabyan.db.api.LocalUserItemsService
import com.aram.mehrabyan.db.api.UserItemEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

internal class RealLocalUserItemsService(
    private val dao: UserItemDao,
    private val dispatchers: AppDispatchers
) : LocalUserItemsService {

    override suspend fun insert(item: UserItemEntity) {
        return withContext(dispatchers.ioDispatcher) { dao.insert(item) }
    }

    override suspend fun delete(item: UserItemEntity) {
        return withContext(dispatchers.ioDispatcher) { dao.delete(item) }
    }

    override fun getAll(): Flow<List<UserItemEntity>> {
        return dao.getAll().flowOn(dispatchers.ioDispatcher)
    }
}