package com.aram.mehrabyan.users.impl.internal.users.ui

import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.aram.mehrabyan.users.impl.R
import com.aram.mehrabyan.users.impl.databinding.FragmentUsersBinding
import com.aram.mehrabyan.users.impl.internal.users.ui.pager.UsersViewPageCreator
import com.aram.mehrabyan.users.impl.internal.users.ui.pager.UsersViewPagerAdapter

internal class RealUsersViewPagerUiController(
    private val pageCreator: UsersViewPageCreator
) : UsersViewPagerUiController {

    override fun setup(fragment: Fragment, binding: FragmentUsersBinding) {
        setOnApplyWindowInsetsListener(binding = binding)
        setupPagerAdapter(fragment = fragment, binding = binding)
        setOnItemSelectedListener(binding = binding)
        registerOnPageChangeCallback(binding = binding)
    }

    private fun setOnApplyWindowInsetsListener(binding: FragmentUsersBinding) {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, insets ->
            val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            binding.tvToolbar.updatePadding(top = statusBarHeight)
            insets
        }
    }

    private fun setupPagerAdapter(fragment: Fragment, binding: FragmentUsersBinding) {
        binding.viewPager.adapter = UsersViewPagerAdapter(
            pageCreator = pageCreator,
            fragment = fragment
        )
    }

    private fun setOnItemSelectedListener(binding: FragmentUsersBinding) {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_random_users -> binding.viewPager.currentItem = 0
                R.id.nav_bookmarks -> binding.viewPager.currentItem = 1
            }
            true
        }
    }

    private fun registerOnPageChangeCallback(binding: FragmentUsersBinding) {
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.tvToolbar.text = pageCreator.getPageTitle(
                    resources = binding.root.resources,
                    position = position
                )
                binding.bottomNavigation.menu.getItem(position).isChecked = true
            }
        })
    }
}