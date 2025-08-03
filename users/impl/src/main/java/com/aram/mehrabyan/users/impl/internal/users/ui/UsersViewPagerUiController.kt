package com.aram.mehrabyan.users.impl.internal.users.ui

import androidx.fragment.app.Fragment
import com.aram.mehrabyan.users.impl.databinding.FragmentUsersBinding
import com.aram.mehrabyan.users.impl.internal.users.UsersNavigationViewModel

internal interface UsersViewPagerUiController {

    fun setup(
        navigator: UsersNavigationViewModel,
        fragment: Fragment,
        binding: FragmentUsersBinding
    )
}