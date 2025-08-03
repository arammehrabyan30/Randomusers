package com.aram.mehrabyan.connector

import android.app.Application
import com.aram.mehrabyan.core.di.coreModule
import com.aram.mehrabyan.db.di.dbModule
import com.aram.mehrabyan.network.di.networkModule
import com.aram.mehrabyan.users.impl.di.usersModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

object KoinStarter {

    fun start(application: Application) {
        startKoin {
            androidContext(application)
            modules(coreModule() + dbModule() + networkModule() + usersModule())
        }
    }
}