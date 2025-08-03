package com.aram.mehrabyan.randomusers

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.aram.mehrabyan.users.api.UsersNavGraphProvider
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val navGraphProvider: UsersNavGraphProvider by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setupNavGraph()
    }

    private fun setupNavGraph() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment
        val navController = navHostFragment.navController
        val navGraph = navGraphProvider.provide(navController = navController)
        navController.setGraph(graph = navGraph, startDestinationArgs = null)
    }
}