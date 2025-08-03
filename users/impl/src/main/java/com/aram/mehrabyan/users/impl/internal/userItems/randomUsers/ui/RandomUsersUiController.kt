package com.aram.mehrabyan.users.impl.internal.userItems.randomUsers.ui

import androidx.fragment.app.Fragment
import com.aram.mehrabyan.users.impl.databinding.FragmentUserItemsBinding
import com.aram.mehrabyan.users.impl.internal.users.UsersNavigationViewModel
import com.aram.mehrabyan.users.impl.internal.userItems.randomUsers.RandomUsersViewModel

internal interface RandomUsersUiController {

    fun setup(
        navigator: UsersNavigationViewModel,
        viewModel: RandomUsersViewModel,
        fragment: Fragment,
        binding: FragmentUserItemsBinding
    )
}