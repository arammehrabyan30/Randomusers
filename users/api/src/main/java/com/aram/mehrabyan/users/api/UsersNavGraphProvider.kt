package com.aram.mehrabyan.users.api

import androidx.navigation.NavController
import androidx.navigation.NavGraph

interface UsersNavGraphProvider {

    fun provide(navController: NavController): NavGraph
}