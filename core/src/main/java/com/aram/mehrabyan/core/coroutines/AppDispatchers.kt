package com.aram.mehrabyan.core.coroutines

import kotlinx.coroutines.CoroutineDispatcher

interface AppDispatchers {
    val ioDispatcher: CoroutineDispatcher
    val mainDispatcher: CoroutineDispatcher
    val defaultDispatcher: CoroutineDispatcher
}