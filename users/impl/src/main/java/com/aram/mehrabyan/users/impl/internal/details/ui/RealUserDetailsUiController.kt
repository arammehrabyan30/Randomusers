package com.aram.mehrabyan.users.impl.internal.details.ui

import android.view.ViewGroup.MarginLayoutParams
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.load
import coil.transform.CircleCropTransformation
import com.aram.mehrabyan.core.ui.UiState
import com.aram.mehrabyan.users.impl.R
import com.aram.mehrabyan.users.impl.databinding.FragmentUserDetailsBinding
import com.aram.mehrabyan.users.impl.internal.details.UserDetailsViewModel
import com.aram.mehrabyan.users.impl.internal.userItems.adapter.UserItemUiModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

internal class RealUserDetailsUiController : UserDetailsUiController {

    override fun setup(
        viewModel: UserDetailsViewModel,
        fragment: Fragment,
        binding: FragmentUserDetailsBinding
    ) {
        setupToolbar(fragment = fragment, binding = binding)
        setOnApplyWindowInsetsListener(binding)
        subscribeToState(
            viewModel = viewModel,
            fragment = fragment,
            binding = binding
        )
    }

    private fun setupToolbar(
        fragment: Fragment,
        binding: FragmentUserDetailsBinding
    ) {
        binding.toolbar.setNavigationIcon(R.drawable.icon_back)
        binding.toolbar.setNavigationOnClickListener {
            fragment.findNavController().popBackStack()
        }
    }

    private fun setOnApplyWindowInsetsListener(binding: FragmentUserDetailsBinding) {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, insets ->
            val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            (binding.toolbar.layoutParams as? MarginLayoutParams)?.let { params ->
                params.topMargin = statusBarHeight
                binding.toolbar.invalidate()
            }
            insets
        }
    }

    private fun subscribeToState(
        viewModel: UserDetailsViewModel,
        fragment: Fragment,
        binding: FragmentUserDetailsBinding
    ) {
        viewModel.state.onEach { state ->
            handleState(
                binding = binding,
                state = state
            )
        }.launchIn(fragment.viewLifecycleOwner.lifecycleScope)
        setupBookmarkAction(viewModel = viewModel, binding = binding)
    }

    private fun setupBookmarkAction(
        viewModel: UserDetailsViewModel,
        binding: FragmentUserDetailsBinding
    ) {
        binding.bookmarkButton.setOnClickListener {
            viewModel.updateBookmark()
        }
    }

    private fun handleState(
        binding: FragmentUserDetailsBinding,
        state: UiState<UserItemUiModel>
    ) {
        if (state is UiState.Success) {
            setupImage(binding = binding, item = state.data)
            setupBookMark(binding = binding, item = state.data)
            setupContent(binding = binding, item = state.data)
        }
    }

    private fun setupImage(
        binding: FragmentUserDetailsBinding,
        item: UserItemUiModel
    ) {
        binding.userImage.load(item.imageUrl ?: item.thumbnail) {
            transformations(CircleCropTransformation())
        }
    }

    private fun setupBookMark(
        binding: FragmentUserDetailsBinding,
        item: UserItemUiModel
    ) {
        val iconRes = if (item.isBookMarked) {
            R.drawable.icon_bookmark_filled
        } else {
            R.drawable.icon_bookmark_outline
        }
        binding.bookmarkButton.icon = ResourcesCompat.getDrawable(
            binding.root.resources,
            iconRes,
            null
        )
    }

    private fun setupContent(
        binding: FragmentUserDetailsBinding,
        item: UserItemUiModel
    ) {
        binding.toolbar.title = item.name
        binding.collapsingToolbar.title = item.name
        binding.tvEmail.text = item.email
        binding.tvPhone.text = item.phone
        binding.tvLocation.text =
            StringBuilder()
                .appendLine(item.country)
                .appendLine()
                .appendLine(item.state)
                .appendLine()
                .appendLine(item.city)
                .appendLine()
                .appendLine(item.street)
                .toString()
    }
}