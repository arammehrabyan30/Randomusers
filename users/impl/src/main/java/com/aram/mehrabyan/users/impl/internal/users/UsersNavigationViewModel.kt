package com.aram.mehrabyan.users.impl.internal.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aram.mehrabyan.users.impl.internal.userItems.adapter.UserItemUiModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

internal class UsersNavigationViewModel : ViewModel() {

    private val _action: MutableSharedFlow<Action> = MutableSharedFlow()
    val action: SharedFlow<Action>
        get() = _action

    fun emitAction(action: Action) {
        viewModelScope.launch { _action.emit(action) }
    }

    sealed interface Action {
        data class OpenUserDetails(val item: UserItemUiModel) : Action
    }
}