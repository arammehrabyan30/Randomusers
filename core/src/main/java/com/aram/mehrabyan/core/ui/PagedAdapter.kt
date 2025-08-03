package com.aram.mehrabyan.core.ui

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class PagedAdapter<T, VH : RecyclerView.ViewHolder>(
    private val loadMore: () -> Unit,
    differCallback: DiffUtil.ItemCallback<T>,
) : ListAdapter<T, VH>(differCallback) {

    override fun onBindViewHolder(holder: VH, position: Int) {
        checkLoadMore(holder = holder)
    }

    private fun checkLoadMore(holder: RecyclerView.ViewHolder) {
        val adapterPosition = holder.adapterPosition
        val checkingIndex = if (itemCount > PREFETCH_DISTANCE)
            itemCount - PREFETCH_DISTANCE else itemCount - 1

        if (currentList.isNotEmpty() && adapterPosition == checkingIndex) {
            loadMore()
        }
    }

    companion object {
        private const val PREFETCH_DISTANCE = 4
    }
}