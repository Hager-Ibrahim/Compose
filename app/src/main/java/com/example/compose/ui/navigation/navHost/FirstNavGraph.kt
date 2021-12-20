package com.example.compose.ui.navigation.navHost

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose.components.fragment.main.DetailScreen
import com.example.compose.components.fragment.main.MainScreen

@Composable
fun SetupNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = "main_screen"){

        composable(route = "main_screen"){
            MainScreen(navHostController)
        }

        composable(route = "detail_screen"){
            DetailScreen()
        }
    }
}