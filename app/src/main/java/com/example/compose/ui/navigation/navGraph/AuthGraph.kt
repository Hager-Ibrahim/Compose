package com.example.compose.ui.navigation.navGraph

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.compose.components.fragment.login.LoginViewModel
import com.example.compose.components.fragment.login.screen.LoginScreen
import androidx.navigation.compose.navigation
import com.example.compose.ui.navigation.AUTH_ROUTE
import com.example.compose.ui.navigation.Screens


fun NavGraphBuilder.authNavGraph(navHostController: NavHostController){
    navigation(
        startDestination = Screens.LoginScreen.route,
        route= AUTH_ROUTE
    ){
        composable(route = Screens.LoginScreen.route) {
            val loginViewModel: LoginViewModel = viewModel()
            LoginScreen(loginViewModel, navHostController)
        }
    }


}