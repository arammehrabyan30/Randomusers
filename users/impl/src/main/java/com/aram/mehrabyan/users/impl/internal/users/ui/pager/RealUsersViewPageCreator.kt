package com.aram.mehrabyan.users.impl.internal.users.ui.pager

import android.content.res.Resources
import androidx.fragment.app.Fragment
import com.aram.mehrabyan.users.impl.R
import com.aram.mehrabyan.users.impl.internal.userItems.bookmarks.BookMarksFragment
import com.aram.mehrabyan.users.impl.internal.userItems.randomUsers.RandomUsersFragment

internal class RealUsersViewPageCreator : UsersViewPageCreator {

    override fun pagesCount(): Int {
        return UsersViewPageCreator.Page.entries.size
    }

    override fun create(position: Int): Fragment {
        return when (UsersViewPageCreator.Page.entries[position]) {
            UsersViewPageCreator.Page.RANDOM_USERS -> {
                RandomUsersFragment.newInstance()
            }
            UsersViewPageCreator.Page.BOOKMARKS -> {
                BookMarksFragment.newInstance()
            }
        }
    }

    override fun getPageTitle(resources: Resources, position: Int): String {
        return when (UsersViewPageCreator.Page.entries[position]) {
            UsersViewPageCreator.Page.RANDOM_USERS -> {
                resources.getString(R.string.random_users_toolbar_title)
            }
            UsersViewPageCreator.Page.BOOKMARKS -> {
                resources.getString(R.string.bookmarks_toolbar_title)
            }
        }
    }
}