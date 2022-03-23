package com.example.compose.ui.navigation.navGraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.compose.modules.main.MainScreen
import com.example.compose.ui.navigation.model.HOME_ROUTE
import com.example.compose.ui.navigation.model.Screens


fun NavGraphBuilder.homeNavGraph(){
    navigation(
        startDestination = Screens.MainScreen.route,
        route = HOME_ROUTE
    ){
        composable(route = Screens.MainScreen.route,
        ) {
            MainScreen()
        }
    }

}