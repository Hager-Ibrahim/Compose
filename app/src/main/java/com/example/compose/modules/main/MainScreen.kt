package com.example.compose.modules.main

import SetupMainNavHost
import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.compose.ui.common.extentions.findStartDestinationId
import com.example.compose.ui.common.extentions.getCurrentDestinationRouteAsState
import com.example.compose.ui.common.extentions.shouldShowBottomBar
import com.example.compose.ui.navigation.model.BottomBarScreen

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            if (navController.shouldShowBottomBar()) {
                BottomBar(navController = navController)
            }
        },
        topBar = {

        },
        floatingActionButton = {

        }
    ) { SetupMainNavHost(navController) }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = BottomBarScreen.values()
    val currentDestinationRoute = navController.getCurrentDestinationRouteAsState()

//    Row{
//
//    }
    BottomNavigation {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                navController = navController,
                selected = currentDestinationRoute == screen.route
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    navController: NavHostController,
    selected: Boolean
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = selected,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.findStartDestinationId()) {
                    saveState = true
                }
            }
        }
    )
}


