package com.aram.mehrabyan.users.impl.internal.users.ui.pager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

internal class UsersViewPagerAdapter(
    private val pageCreator: UsersViewPageCreator,
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return pageCreator.pagesCount()
    }

    override fun createFragment(position: Int): Fragment {
        return pageCreator.create(position)
    }
}