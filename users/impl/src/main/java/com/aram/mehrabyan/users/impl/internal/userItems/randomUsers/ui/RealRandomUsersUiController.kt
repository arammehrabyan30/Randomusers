package com.aram.mehrabyan.users.impl.internal.userItems.randomUsers.ui

import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.aram.mehrabyan.core.ui.UiState
import com.aram.mehrabyan.core.ui.gone
import com.aram.mehrabyan.core.ui.show
import com.aram.mehrabyan.core.utils.RandomUsersNoNetworkException
import com.aram.mehrabyan.users.impl.R
import com.aram.mehrabyan.users.impl.databinding.FragmentUserItemsBinding
import com.aram.mehrabyan.users.impl.internal.users.UsersNavigationViewModel
import com.aram.mehrabyan.users.impl.internal.userItems.adapter.UserItemsAdapter
import com.aram.mehrabyan.users.impl.internal.userItems.randomUsers.RandomUsersViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

internal class RealRandomUsersUiController : RandomUsersUiController {

    override fun setup(
        navigator: UsersNavigationViewModel,
        viewModel: RandomUsersViewModel,
        fragment: Fragment,
        binding: FragmentUserItemsBinding
    ) {
        val adapter = createAdapter(navigator = navigator, viewModel = viewModel)
        setupAdapter(binding = binding, adapter = adapter)
        subscribeToUiState(
            viewModel = viewModel,
            fragment = fragment,
            binding = binding,
            adapter = adapter
        )
        setOnRefreshListener(binding = binding, viewModel = viewModel)
    }

    private fun setupAdapter(binding: FragmentUserItemsBinding, adapter: UserItemsAdapter) {
        with(binding.rvUserItems) {
            layoutManager = LinearLayoutManager(binding.rvUserItems.context)
            this.adapter = adapter
        }
    }

    private fun subscribeToUiState(
        viewModel: RandomUsersViewModel,
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
        state: UiState<RandomUsersUiData>
    ) {
        when (state) {
            is UiState.Success -> {
                setupRefreshState(binding = binding, isEnabled = true)
                hideProgressIndicators(binding)
                handleErrorState(show = false, binding = binding)
                adapter.submitList(state.data.items)
            }
            is UiState.Loading -> {
                handleErrorState(show = false, binding = binding)
                showProgressIndicators(binding = binding, state = state)
            }
            is UiState.Error -> {
                setupRefreshState(binding = binding, isRefreshing = false, isEnabled = true)
                hideProgressIndicators(binding)
                handleErrorState(show = true, binding = binding, exception = state.exception)
            }
            is UiState.Initial -> {
                setupRefreshState(binding)
            }
        }
    }

    private fun createAdapter(
        navigator: UsersNavigationViewModel,
        viewModel: RandomUsersViewModel
    ): UserItemsAdapter {
        return UserItemsAdapter(
            openDetailsClick = { item ->
                navigator.emitAction(UsersNavigationViewModel.Action.OpenUserDetails(item))
            },
            bookmarkClick = { item ->
                viewModel.bookmark(item)
            },
            loadMore = {
                viewModel.loadNextPage()
            }
        )
    }

    private fun showProgressIndicators(
        binding: FragmentUserItemsBinding,
        state: UiState.Loading<*>
    ) {
        when (state) {
            is UiState.Loading.PageLoading -> {
                binding.progressIndicator.show()
                binding.loadMore.root.gone()
            }
            is UiState.Loading.NextPageLoading -> {
                binding.progressIndicator.gone()
                binding.loadMore.root.show()
            }
        }
    }

    private fun hideProgressIndicators(binding: FragmentUserItemsBinding) {
        binding.progressIndicator.gone()
        binding.loadMore.root.gone()
    }

    private fun handleErrorState(
        show: Boolean,
        binding: FragmentUserItemsBinding,
        exception: Throwable? = null
    ) {
        binding.tvError.isVisible = show
        if (show) {
            binding.tvError.text = if (exception is RandomUsersNoNetworkException) {
                binding.root.resources.getString(R.string.no_network_title)
            } else {
                binding.root.resources.getString(R.string.error_title)
            }
        }
    }

    private fun setupRefreshState(
        binding: FragmentUserItemsBinding,
        isRefreshing: Boolean = false,
        isEnabled: Boolean = false
    ) {
        binding.refreshLayout.isRefreshing = isRefreshing
        binding.refreshLayout.isEnabled = isEnabled
    }

    private fun setOnRefreshListener(
        binding: FragmentUserItemsBinding,
        viewModel: RandomUsersViewModel
    ) {
        binding.refreshLayout.setOnRefreshListener {
            viewModel.refresh()
        }
    }
}
