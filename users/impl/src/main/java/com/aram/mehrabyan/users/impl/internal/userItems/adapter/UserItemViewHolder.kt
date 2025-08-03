package com.aram.mehrabyan.users.impl.internal.userItems.adapter

import android.graphics.drawable.Drawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.aram.mehrabyan.users.impl.R
import com.aram.mehrabyan.users.impl.databinding.ItemUserBinding

internal class UserItemViewHolder(
    private val binding: ItemUserBinding,
    private val bookmarkClick: (UserItemUiModel) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(itemUiModel: UserItemUiModel) {
        bindUserImage(itemUiModel)
        bindTitles(itemUiModel)
        bindBookmark(itemUiModel)
        setupClickListeners(itemUiModel)
    }

    private fun setupClickListeners(itemUiModel: UserItemUiModel) {
        binding.iconBookmark.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                bookmarkClick(itemUiModel)
            }
        }
    }

    private fun bindUserImage(itemUiModel: UserItemUiModel) {
        binding.imageUser.load(itemUiModel.imageUrl ?: itemUiModel.thumbnail) {
            val placeholder = createPlaceHolderImage()
            transformations(CircleCropTransformation())
            placeholder(placeholder)
            error(placeholder)
        }
    }

    private fun bindTitles(itemUiModel: UserItemUiModel) {
        binding.tvTitle.text = itemUiModel.name
        binding.tvSubTitle.text = itemUiModel.city
    }

    private fun bindBookmark(itemUiModel: UserItemUiModel) {
        val bookmarkImageRes = if (itemUiModel.isBookMarked) {
            R.drawable.icon_bookmark_filled
        } else {
            R.drawable.icon_bookmark_outline
        }
        binding.iconBookmark.setColorFilter(
            ResourcesCompat.getColor(binding.root.resources, R.color.title_color, null)
        )
        binding.iconBookmark.setImageResource(bookmarkImageRes)
    }

    private fun createPlaceHolderImage(): Drawable {
        return ShapeDrawable(OvalShape()).apply {
            intrinsicWidth = binding.imageUser.measuredWidth
            intrinsicHeight = binding.imageUser.measuredHeight
            paint.color = ResourcesCompat.getColor(
                binding.root.resources,
                R.color.image_bg,
                null
            )
        }
    }
}