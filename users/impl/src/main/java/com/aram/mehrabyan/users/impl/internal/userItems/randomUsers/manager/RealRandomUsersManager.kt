package com.aram.mehrabyan.users.impl.internal.userItems.randomUsers.manager

import com.aram.mehrabyan.core.coroutines.AppDispatchers
import com.aram.mehrabyan.core.data.ActionResult
import com.aram.mehrabyan.core.utils.RandomUsersApiException
import com.aram.mehrabyan.core.utils.RandomUsersNoNetworkException
import com.aram.mehrabyan.db.api.UserItemEntity
import com.aram.mehrabyan.network.api.ApiResult
import com.aram.mehrabyan.users.impl.internal.data.UsersRepo
import com.aram.mehrabyan.users.impl.internal.data.entity.RandomUsersApiModel
import com.aram.mehrabyan.users.impl.internal.data.mapper.UserApiModelsToUiModelsMapper
import com.aram.mehrabyan.users.impl.internal.userItems.randomUsers.ui.RandomUsersUiData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.withContext

internal class RealRandomUsersManager(
    private val usersRepo: UsersRepo,
    private val mapper: UserApiModelsToUiModelsMapper,
    private val dispatchers: AppDispatchers
) : RandomUsersManager {

    override suspend fun getRandomUsers(
        loadedItems: RandomUsersUiData?
    ): ActionResult<RandomUsersUiData> {
        return withContext(dispatchers.ioDispatcher) {
            val apiResult = usersRepo.getRandomUsers(
                page = loadedItems?.currentPage?.inc() ?: RandomUsersUiData.INITIAL_PAGE,
                limit = RandomUsersUiData.PAGE_LIMIT
            )
            when (apiResult) {
                is ApiResult.Success -> {
                    handleApiSuccessResult(
                        prevLoadedItems = loadedItems,
                        result = apiResult
                    )
                }
                is ApiResult.Error -> {
                    loadedItems?.let { data ->
                        ActionResult.Success(data)
                    } ?: handleApiErrorResult(result = apiResult)
                }
            }
        }
    }


    override fun getAllBookmarkedUsers(): Flow<List<UserItemEntity>> {
        return usersRepo.getAllBookmarkedUsers()
    }

    override fun handleDataWithBookmarks(
        loadedItems: RandomUsersUiData,
        bookmarks: List<UserItemEntity>
    ): RandomUsersUiData {
        val items = loadedItems.items.toMutableList().mapIndexed { index, model ->
            when {
                bookmarks.any { it.id == model.id } -> {
                    if (!model.isBookMarked) model.copy(isBookMarked = true) else model
                }
                model.isBookMarked -> model.copy(isBookMarked = false)
                else -> model
            }
        }
        return loadedItems.copy(items = items)
    }

    private suspend fun handleApiSuccessResult(
        prevLoadedItems: RandomUsersUiData?,
        result: ApiResult.Success<RandomUsersApiModel>
    ): ActionResult<RandomUsersUiData> {
        val loadedItems = mapper.map(
            items = result.data.results,
            bookMarkedItems = usersRepo.getAllBookmarkedUsers().firstOrNull()
        )
        val hasNextPage = !result.data.results.isNullOrEmpty()
                && result.data.loadInfo != null
        val itemsData = prevLoadedItems?.items?.let { items ->
            items + loadedItems
        } ?: loadedItems

        val data = RandomUsersUiData(
            items = itemsData,
            currentPage = result.data.loadInfo?.page,
            hasNextPage = hasNextPage
        )
        return ActionResult.Success(data = data)
    }

    private fun handleApiErrorResult(
        result: ApiResult.Error
    ): ActionResult.Error {
        return when (result) {
            is ApiResult.Error.NetworkError -> {
                ActionResult.Error(RandomUsersNoNetworkException())
            }
            is ApiResult.Error.ApiError -> {
                val exception = RandomUsersApiException(
                    code = result.code,
                    message = result.message
                )
                ActionResult.Error(exception = exception)
            }
        }
    }
}