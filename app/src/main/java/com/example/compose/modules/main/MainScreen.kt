package com.example.compose.modules.main

import SetupMainNavHost
import android.util.Log
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.compose.ui.navigation.model.BottomBarScreen

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            if(navController.shouldShowBottomBar()){
                BottomBar(navController = navController)
            }
        }
    ) {
        SetupMainNavHost(navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = BottomBarScreen.values()

    val currentDestinationRoute = navController.getCurrentDestinationRouteAsState()

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
            navController.navigate(screen.route)
        }
    )
}

val bottomBarTabs = BottomBarScreen.values()
private val bottomBarRoutes = bottomBarTabs.map { it.route }

@Composable
fun NavHostController.getCurrentDestinationRouteAsState()= currentBackStackEntryAsState().value?.destination?.route

@Composable
fun NavHostController.shouldShowBottomBar(): Boolean{
    return getCurrentDestinationRouteAsState() in bottomBarRoutes
}
