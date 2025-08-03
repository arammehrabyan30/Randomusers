package com.aram.mehrabyan.users.impl.internal.details.ui

import androidx.fragment.app.Fragment
import com.aram.mehrabyan.users.impl.databinding.FragmentUserDetailsBinding
import com.aram.mehrabyan.users.impl.internal.details.UserDetailsViewModel

internal interface UserDetailsUiController {

    fun setup(
        viewModel: UserDetailsViewModel,
        fragment: Fragment,
        binding: FragmentUserDetailsBinding
    )
}