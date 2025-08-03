package com.aram.mehrabyan.users.impl.internal.userItems.adapter

import androidx.recyclerview.widget.DiffUtil

internal class UserItemDiffCallback : DiffUtil.ItemCallback<UserItemUiModel>() {
    override fun areItemsTheSame(
        oldItem: UserItemUiModel,
        newItem: UserItemUiModel
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: UserItemUiModel,
        newItem: UserItemUiModel
    ): Boolean {
        return oldItem == newItem
    }
}