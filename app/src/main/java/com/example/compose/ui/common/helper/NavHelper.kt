package com.example.compose.ui.navigation

import android.os.Parcelable
import androidx.navigation.*


fun NavController.navigate(route: String, vararg args: Pair<String, Parcelable>) {
    navigate(route)

    requireNotNull(currentBackStackEntry?.arguments).apply {
        args.forEach { (key: String, arg: Parcelable) ->
            putParcelable(key, arg)
        }
    }
}

inline fun <reified T : Parcelable> NavBackStackEntry.getParcelable(key: String): T {
    return requireNotNull(arguments) { "arguments bundle is null" }.run {
        requireNotNull(getParcelable(key)) { "argument for $key is null" }
    }
}