package com.example.compose.ui.common.extentions

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
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

