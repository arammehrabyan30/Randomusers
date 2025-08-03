package com.aram.mehrabyan.users.impl.internal.users.ui

import androidx.fragment.app.Fragment
import com.aram.mehrabyan.users.impl.databinding.FragmentUsersBinding

internal interface UsersViewPagerUiController {

    fun setup(fragment: Fragment, binding: FragmentUsersBinding)
}