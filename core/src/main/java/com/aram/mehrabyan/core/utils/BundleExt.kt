package com.aram.mehrabyan.core.utils

import android.os.Build
import android.os.Bundle

inline fun <reified T> Bundle.fetchParcelable(key: String): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelable(key, T::class.java)
    } else {
        getParcelable(key) as? T
    }
}
