package com.example.compose.modules.main

import SetupMainNavHost
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.compose.ui.common.extentions.getCurrentDestinationRouteAsState
import com.example.compose.ui.common.extentions.openScreen
import com.example.compose.ui.common.extentions.shouldShowBottomBar
import com.example.compose.ui.navigation.model.BottomBarScreen
import com.example.compose.ui.theme.LightBlueGray
import com.example.compose.ui.theme.TextPrimary

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

    BottomNavigation(backgroundColor = Color.White) {
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
        selectedContentColor = TextPrimary,
        unselectedContentColor = LightBlueGray,
        onClick = {
            navController.openScreen(screen.route)
        }
    )
}


