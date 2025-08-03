package com.aram.mehrabyan.randomusers

import android.app.Application
import com.aram.mehrabyan.connector.KoinStarter

internal class RandomUsersApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        KoinStarter.start(application = this)
    }
}