package com.aram.mehrabyan.users.impl.internal.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.aram.mehrabyan.core.utils.fetchParcelable
import com.aram.mehrabyan.users.impl.R
import com.aram.mehrabyan.users.impl.databinding.FragmentUserDetailsBinding
import com.aram.mehrabyan.users.impl.internal.details.ui.UserDetailsUiController
import com.aram.mehrabyan.users.impl.internal.userItems.adapter.UserItemUiModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

internal class UserDetailsFragment : Fragment(R.layout.fragment_user_details) {

    private val viewModel: UserDetailsViewModel by viewModel {
        parametersOf(arguments?.fetchParcelable<UserItemUiModel>(ARGS_KEY))
    }
    private val uiController: UserDetailsUiController by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentUserDetailsBinding.bind(view)
        setup(binding = binding)
    }

    private fun setup(binding: FragmentUserDetailsBinding) {
        uiController.setup(
            viewModel = viewModel,
            fragment = this,
            binding = binding
        )
    }

    companion object {
        const val ARGS_KEY: String = "UserDetailsFragment.ARGS"
    }
}