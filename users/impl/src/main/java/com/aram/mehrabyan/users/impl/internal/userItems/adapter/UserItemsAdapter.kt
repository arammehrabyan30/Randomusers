package com.aram.mehrabyan.users.impl.internal.userItems.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.aram.mehrabyan.core.ui.PagedAdapter
import com.aram.mehrabyan.users.impl.databinding.ItemUserBinding

internal class UserItemsAdapter(
    private val openDetailsClick: (UserItemUiModel) -> Unit,
    private val bookmarkClick: (UserItemUiModel) -> Unit,
    loadMore: (() -> Unit)? = null
) : PagedAdapter<UserItemUiModel, UserItemViewHolder>(
    loadMore = loadMore ?: {},
    differCallback = UserItemDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        val binding = ItemUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UserItemViewHolder(
            binding = binding,
            openDetailsClick = openDetailsClick,
            bookmarkClick = bookmarkClick
        )
    }

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(getItem(position))
    }
}