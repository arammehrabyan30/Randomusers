package com.aram.mehrabyan.core.utils

class RandomUsersNoNetworkException() : Exception()

class RandomUsersApiException(val code: Int, override val message: String?) : Exception(message)
