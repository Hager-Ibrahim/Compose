package com.example.compose.ui.navigation.navGraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.compose.modules.profiledetails.ProfileDetailsScreen
import com.example.compose.ui.navigation.model.BottomBarScreen
import com.example.compose.ui.navigation.model.Screens

fun NavGraphBuilder.setupMainNavGraph(navController: NavHostController) {
    navigation(
        route = Screens.MainScreen.route,
        startDestination = BottomBarScreen.Home.route
    ) {
        bottomNavGraph(navController)
    }
    composable(
        route = Screens.ProfileDetailsScreen.route
    ) {
        ProfileDetailsScreen()
    }
}