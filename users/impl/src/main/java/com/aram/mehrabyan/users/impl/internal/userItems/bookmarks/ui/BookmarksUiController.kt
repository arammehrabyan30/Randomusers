package com.aram.mehrabyan.users.impl.internal.userItems.bookmarks.ui

import androidx.fragment.app.Fragment
import com.aram.mehrabyan.users.impl.databinding.FragmentUserItemsBinding
import com.aram.mehrabyan.users.impl.internal.userItems.bookmarks.BookMarksViewModel

internal interface BookmarksUiController {

    fun setup(
        viewModel: BookMarksViewModel,
        fragment: Fragment,
        binding: FragmentUserItemsBinding
    )
}