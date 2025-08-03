package com.aram.mehrabyan.db.di

import com.aram.mehrabyan.db.api.LocalUserItemsService
import com.aram.mehrabyan.db.internal.AppDatabase
import com.aram.mehrabyan.db.internal.RealLocalUserItemsService
import com.aram.mehrabyan.db.internal.UserItemDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

fun dbModule() = module {
    single<UserItemDao> {
        AppDatabase.getInstance(androidContext()).userItemDao()
    }

    single<LocalUserItemsService> {
        RealLocalUserItemsService(dao = get(), dispatchers = get())
    }
}