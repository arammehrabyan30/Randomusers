package com.aram.mehrabyan.users.impl.internal.users

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.aram.mehrabyan.users.impl.R
import com.aram.mehrabyan.users.impl.databinding.FragmentUsersBinding
import com.aram.mehrabyan.users.impl.internal.users.ui.UsersViewPagerUiController
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel

internal class UsersFragment : Fragment(R.layout.fragment_users) {

    private val navigator: UsersNavigationViewModel by activityViewModel()
    private val pagerUiController: UsersViewPagerUiController by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentUsersBinding.bind(view)
        setupUi(binding)
    }

    private fun setupUi(binding: FragmentUsersBinding) {
        pagerUiController.setup(
            navigator = navigator,
            fragment = this,
            binding = binding
        )
    }
}