package com.example.compose.ui.navigation

import androidx.navigation.NavHostController
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.example.compose.ui.navigation.navGraph.authNavGraph
import com.example.compose.ui.navigation.navGraph.homeNavGraph

@Composable
fun SetupMainNavGraphFifth(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = AUTH_ROUTE,
       // route = "rooot"
    ) {

        authNavGraph(navHostController)

        homeNavGraph()

    }
}