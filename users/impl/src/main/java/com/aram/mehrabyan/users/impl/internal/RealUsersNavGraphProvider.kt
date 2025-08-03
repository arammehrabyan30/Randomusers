package com.aram.mehrabyan.users.impl.internal

import androidx.navigation.NavController
import androidx.navigation.NavGraph
import com.aram.mehrabyan.users.api.UsersNavGraphProvider
import com.aram.mehrabyan.users.impl.R

internal class RealUsersNavGraphProvider : UsersNavGraphProvider {

    override fun provide(navController: NavController): NavGraph {
        return navController.navInflater.inflate(R.navigation.users_nav_graph)
    }
}