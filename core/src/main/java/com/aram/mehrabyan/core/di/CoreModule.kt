package com.aram.mehrabyan.core.di

import com.aram.mehrabyan.core.coroutines.AppDispatchers
import com.aram.mehrabyan.core.coroutines.RealAppDispatchers
import org.koin.dsl.module

fun coreModule() = module {
    single<AppDispatchers> { RealAppDispatchers }
}