package com.aram.mehrabyan.users.impl.internal.userItems.randomUsers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aram.mehrabyan.core.data.ActionResult
import com.aram.mehrabyan.core.ui.UiState
import com.aram.mehrabyan.users.impl.internal.userItems.adapter.UserItemUiModel
import com.aram.mehrabyan.users.impl.internal.userItems.manager.BookmarksManager
import com.aram.mehrabyan.users.impl.internal.userItems.randomUsers.manager.RandomUsersManager
import com.aram.mehrabyan.users.impl.internal.userItems.randomUsers.ui.RandomUsersUiData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

internal class RandomUsersViewModel(
    private val manager: RandomUsersManager,
    private val bookmarksManager: BookmarksManager
) : ViewModel() {

    private val _state: MutableStateFlow<UiState<RandomUsersUiData>> =
        MutableStateFlow(UiState.Initial)
    val state: StateFlow<UiState<RandomUsersUiData>>
        get() = _state

    init {
        loadData()
        subscribeToBookmarks()
    }

    fun refresh() {
        loadData()
    }

    fun loadNextPage() {
        getLoadedItemsData()?.let { data ->
            if (data.hasNextPage) {
                loadData(loadedData = data)
            }
        }
    }

    fun bookmark(item: UserItemUiModel) {
        viewModelScope.launch {
            if (item.isBookMarked) {
                bookmarksManager.deleteBookmarkedUser(item)
            } else {
                bookmarksManager.bookmarkUser(item)
            }
        }
    }

    private fun loadData(loadedData: RandomUsersUiData? = null) {
        viewModelScope.launch {
            setupLoadingState(loadedData)
            when (val result = manager.getRandomUsers(loadedItems = loadedData)) {
                is ActionResult.Success -> setupSuccessState(data = result.data)
                is ActionResult.Error -> setupErrorState(exception = result.exception)
            }
        }
    }

    private fun subscribeToBookmarks() {
        manager.getAllBookmarkedUsers().onEach { bookmarks ->
            getLoadedItemsData()?.let { loadedItems ->
                val data = manager.handleDataWithBookmarks(
                    loadedItems = loadedItems,
                    bookmarks = bookmarks
                )
                setupSuccessState(data = data)
            }
        }.launchIn(viewModelScope)
    }

    private fun setupSuccessState(data: RandomUsersUiData) {
        _state.value = UiState.Success(data = data)
    }

    private fun setupLoadingState(loadedData: RandomUsersUiData?) {
        _state.value = loadedData?.let { data ->
            UiState.Loading.NextPageLoading(data = data)
        } ?: UiState.Loading.PageLoading
    }

    private fun setupErrorState(exception: Exception?) {
        if (getLoadedItemsData() == null) {
            _state.value = UiState.Error(exception = exception)
        }
    }

    private fun getLoadedItemsData(): RandomUsersUiData? {
        return (_state.value as? UiState.Success<RandomUsersUiData>)?.data
    }
}