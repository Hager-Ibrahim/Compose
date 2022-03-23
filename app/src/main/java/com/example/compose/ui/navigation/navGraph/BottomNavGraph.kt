package com.example.compose.ui.navigation.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose.modules.home.HomeScreen
import com.example.compose.modules.profile.ProfileScreen
import com.example.compose.modules.settings.SettingsScreen
import com.example.compose.ui.navigation.model.BottomBarScreen.*

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Home.route
    ) {
        composable(route = Home.route) {
            HomeScreen()
        }
        composable(route = Profile.route) {
            ProfileScreen()
        }
        composable(route = Settings.route) {
            SettingsScreen()
        }
    }
}