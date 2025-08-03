package com.aram.mehrabyan.users.impl.internal.userItems.randomUsers.ui

import androidx.fragment.app.Fragment
import com.aram.mehrabyan.users.impl.databinding.FragmentUserItemsBinding
import com.aram.mehrabyan.users.impl.internal.userItems.randomUsers.RandomUsersViewModel

internal interface RandomUsersUiController {

    fun setup(
        viewModel: RandomUsersViewModel,
        fragment: Fragment,
        binding: FragmentUserItemsBinding
    )
}