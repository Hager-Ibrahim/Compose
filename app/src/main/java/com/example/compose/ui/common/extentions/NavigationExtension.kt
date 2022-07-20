package com.example.compose.ui.common.extentions

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.compose.ui.navigation.model.BottomBarScreen

val bottomBarTabs = BottomBarScreen.values()
private val bottomBarRoutes = bottomBarTabs.map { it.route }

@Composable
fun NavHostController.getCurrentDestinationRouteAsState() =
    currentBackStackEntryAsState().value?.destination?.route

@Composable
fun NavHostController.shouldShowBottomBar(): Boolean {
    return getCurrentDestinationRouteAsState() in bottomBarRoutes
}

fun NavHostController.findStartDestinationId() = graph.findStartDestination().id

fun NavHostController.openScreen(route: String) {
    navigate(route = route) {
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(findStartDestinationId()) {
            saveState = true
        }
    }
}