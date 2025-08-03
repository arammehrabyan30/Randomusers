package com.aram.mehrabyan.core.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal object RealAppDispatchers : AppDispatchers {
    override val ioDispatcher: CoroutineDispatcher by lazy { Dispatchers.IO }
    override val mainDispatcher: CoroutineDispatcher by lazy { Dispatchers.Main.immediate }
    override val defaultDispatcher: CoroutineDispatcher by lazy { Dispatchers.Default }
}