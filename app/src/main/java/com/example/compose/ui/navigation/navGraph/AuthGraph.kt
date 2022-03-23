package com.example.compose.ui.navigation.navGraph

import androidx.navigation.*
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.compose.modules.login.LoginScreen
import com.example.compose.ui.navigation.model.AUTH_ROUTE
import com.example.compose.ui.navigation.model.Screens


fun NavGraphBuilder.authNavGraph(navHostController: NavHostController){
    navigation(
        startDestination = Screens.LoginScreen.route,
        route= AUTH_ROUTE
    ){
        composable(route = Screens.LoginScreen.route) {
            LoginScreen()
        }
    }


}