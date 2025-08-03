package com.aram.mehrabyan.users.impl.internal.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aram.mehrabyan.core.ui.UiState
import com.aram.mehrabyan.users.impl.internal.userItems.adapter.UserItemUiModel
import com.aram.mehrabyan.users.impl.internal.userItems.manager.BookmarksManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class UserDetailsViewModel(
    private val bookmarksManager: BookmarksManager,
    item: UserItemUiModel?
) : ViewModel() {

    private val _state: MutableStateFlow<UiState<UserItemUiModel>> =
        MutableStateFlow(UiState.Initial)
    val state: StateFlow<UiState<UserItemUiModel>>
        get() = _state

    init {
        setupState(item)
    }

    fun updateBookmark() {
        (_state.value as? UiState.Success<UserItemUiModel>)?.data?.let { item ->
            viewModelScope.launch {
                if (item.isBookMarked) {
                    bookmarksManager.deleteBookmarkedUser(item)
                } else {
                    bookmarksManager.bookmarkUser(item)
                }
                _state.value = UiState.Success(item.copy(isBookMarked = !item.isBookMarked))
            }
        }
    }

    private fun setupState(item: UserItemUiModel?) {
        if (item != null) {
            _state.value = UiState.Success(item)
        } else {
            _state.value = UiState.Error()
        }
    }
}