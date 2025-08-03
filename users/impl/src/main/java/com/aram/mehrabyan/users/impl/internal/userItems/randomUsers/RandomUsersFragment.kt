package com.aram.mehrabyan.users.impl.internal.userItems.randomUsers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.aram.mehrabyan.users.impl.R
import com.aram.mehrabyan.users.impl.databinding.FragmentUserItemsBinding
import com.aram.mehrabyan.users.impl.internal.users.UsersNavigationViewModel
import com.aram.mehrabyan.users.impl.internal.userItems.randomUsers.ui.RandomUsersUiController
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class RandomUsersFragment : Fragment(R.layout.fragment_user_items) {

    private val navigator: UsersNavigationViewModel by activityViewModel()
    private val viewModel: RandomUsersViewModel by viewModel()
    private val uiController: RandomUsersUiController by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentUserItemsBinding.bind(view)
        setup(binding)
    }

    private fun setup(binding: FragmentUserItemsBinding) {
        uiController.setup(
            navigator = navigator,
            viewModel = viewModel,
            fragment = this,
            binding = binding
        )
    }

    companion object {
        fun newInstance(): Fragment {
            return RandomUsersFragment()
        }
    }
}