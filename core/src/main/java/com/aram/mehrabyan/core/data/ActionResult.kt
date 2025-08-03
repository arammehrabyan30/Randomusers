package com.aram.mehrabyan.core.data

sealed interface ActionResult<out R> {
    data class Success<out T>(val data: T) : ActionResult<T>
    data class Error(val exception: Exception? = null) : ActionResult<Nothing>
}