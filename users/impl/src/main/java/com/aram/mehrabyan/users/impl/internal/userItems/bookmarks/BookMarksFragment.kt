package com.aram.mehrabyan.users.impl.internal.userItems.bookmarks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.aram.mehrabyan.users.impl.R
import com.aram.mehrabyan.users.impl.databinding.FragmentUserItemsBinding
import com.aram.mehrabyan.users.impl.internal.users.UsersNavigationViewModel
import com.aram.mehrabyan.users.impl.internal.userItems.bookmarks.ui.BookmarksUiController
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class BookMarksFragment : Fragment(R.layout.fragment_user_items) {

    private val navigator: UsersNavigationViewModel by activityViewModel()
    private val viewModel: BookMarksViewModel by viewModel()
    private val uUiController: BookmarksUiController by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentUserItemsBinding.bind(view)
        setup(binding = binding)
    }

    private fun setup(binding: FragmentUserItemsBinding) {
        uUiController.setup(
            navigator = navigator,
            viewModel = viewModel,
            fragment = this,
            binding = binding
        )
    }

    companion object {
        fun newInstance(): Fragment {
            return BookMarksFragment()
        }
    }
}