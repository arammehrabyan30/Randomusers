package com.aram.mehrabyan.users.impl.internal.userItems.bookmarks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aram.mehrabyan.core.ui.UiState
import com.aram.mehrabyan.users.impl.internal.userItems.adapter.UserItemUiModel
import com.aram.mehrabyan.users.impl.internal.userItems.bookmarks.manager.AllBookmarksManager
import com.aram.mehrabyan.users.impl.internal.userItems.manager.BookmarksManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

internal class BookMarksViewModel(
    private val manager: AllBookmarksManager,
    private val bookmarksManager: BookmarksManager
) : ViewModel() {

    private val _state: MutableStateFlow<UiState<List<UserItemUiModel>>> =
        MutableStateFlow(UiState.Initial)
    val state: StateFlow<UiState<List<UserItemUiModel>>>
        get() = _state

    init {
        loadData()
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

    private fun loadData() {
        _state.value = UiState.Loading.PageLoading

        manager.getAllBookmarkedUsers().onEach { data ->
            _state.value = UiState.Success(data)
        }.launchIn(viewModelScope)
    }
}