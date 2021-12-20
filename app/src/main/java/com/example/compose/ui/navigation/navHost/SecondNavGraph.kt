package com.example.compose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose.components.fragment.login.LoginViewModel
import com.example.compose.components.fragment.login.screen.*
import com.example.compose.components.fragment.staff.StaffViewModel
import com.example.compose.components.fragment.staff.screen.StaffScreen
import com.example.compose.ui.navigation.Screens.*
@Composable
fun SetupMainNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = LoginScreen.route){

        composable(route = LoginScreen.route){
            val loginViewModel : LoginViewModel = viewModel()
            LoginScreen(loginViewModel, navHostController)
        }

        composable(route = StaffScreen.route){
            val staffViewModel : StaffViewModel = viewModel()
            StaffScreen(staffViewModel)
        }
    }
}