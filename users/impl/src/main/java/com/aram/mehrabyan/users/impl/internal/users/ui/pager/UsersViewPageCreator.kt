package com.aram.mehrabyan.users.impl.internal.users.ui.pager

import android.content.res.Resources
import androidx.fragment.app.Fragment

internal interface UsersViewPageCreator {

    fun pagesCount(): Int

    fun create(position: Int): Fragment

    fun getPageTitle(resources: Resources, position: Int): String

    enum class Page {
        RANDOM_USERS, BOOKMARKS
    }
}