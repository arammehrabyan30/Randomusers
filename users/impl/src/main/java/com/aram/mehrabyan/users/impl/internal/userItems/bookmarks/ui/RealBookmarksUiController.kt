package com.aram.mehrabyan.users.impl.internal.userItems.bookmarks.ui

import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.aram.mehrabyan.core.ui.UiState
import com.aram.mehrabyan.core.ui.gone
import com.aram.mehrabyan.core.ui.show
import com.aram.mehrabyan.users.impl.R
import com.aram.mehrabyan.users.impl.databinding.FragmentUserItemsBinding
import com.aram.mehrabyan.users.impl.internal.userItems.adapter.UserItemUiModel
import com.aram.mehrabyan.users.impl.internal.userItems.adapter.UserItemsAdapter
import com.aram.mehrabyan.users.impl.internal.userItems.bookmarks.BookMarksViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

internal class RealBookmarksUiController : BookmarksUiController {

    override fun setup(
        viewModel: BookMarksViewModel,
        fragment: Fragment,
        binding: FragmentUserItemsBinding
    ) {
        binding.refreshLayout.isEnabled = false
        binding.tvError.text =
            binding.root.resources.getString(R.string.empty_bookmarks_title)
        val adapter = createAdapter(viewModel = viewModel)
        setupAdapter(binding = binding, adapter = adapter)
        subscribeToUiState(
            viewModel = viewModel,
            fragment = fragment,
            binding = binding,
            adapter = adapter
        )
    }

    private fun setupAdapter(binding: FragmentUserItemsBinding, adapter: UserItemsAdapter) {
        with(binding.rvUserItems) {
            layoutManager = LinearLayoutManager(binding.rvUserItems.context)
            this.adapter = adapter
        }
    }

    private fun subscribeToUiState(
        viewModel: BookMarksViewModel,
        fragment: Fragment,
        binding: FragmentUserItemsBinding,
        adapter: UserItemsAdapter
    ) {
        viewModel.state.onEach { state ->
            handleUiState(adapter = adapter, binding = binding, state = state)
        }.launchIn(fragment.viewLifecycleOwner.lifecycleScope)
    }

    private fun handleUiState(
        adapter: UserItemsAdapter,
        binding: FragmentUserItemsBinding,
        state: UiState<List<UserItemUiModel>>
    ) {
        when (state) {
            is UiState.Success -> {
                adapter.submitList(state.data)
                binding.progressIndicator.gone()
                binding.tvError.isVisible = state.data.isEmpty()
            }
            is UiState.Loading -> {
                binding.progressIndicator.show()
            }
            else -> Unit
        }
    }

    private fun createAdapter(viewModel: BookMarksViewModel): UserItemsAdapter {
        return UserItemsAdapter(
            bookmarkClick = { item -> viewModel.bookmark(item) }
        )
    }
}