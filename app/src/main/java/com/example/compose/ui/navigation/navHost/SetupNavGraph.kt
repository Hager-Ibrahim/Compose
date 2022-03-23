package com.example.compose.ui.navigation.navHost

import androidx.navigation.NavHostController
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.example.compose.ui.navigation.model.HOME_ROUTE
import com.example.compose.ui.navigation.navGraph.authNavGraph
import com.example.compose.ui.navigation.navGraph.homeNavGraph

@Composable
fun SetupMainNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = HOME_ROUTE,
    ) {

        authNavGraph(navHostController)

        homeNavGraph()

    }
}