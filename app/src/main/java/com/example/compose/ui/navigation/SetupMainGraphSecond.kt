package com.example.compose.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavArgument
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.compose.components.fragment.login.LoginViewModel
import com.example.compose.components.fragment.login.screen.LoginScreen
import com.example.compose.components.fragment.staff.StaffViewModel
import com.example.compose.components.fragment.staff.screen.StaffScreen

@Composable
fun SetupMainNavGraphSecond(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.LoginScreen.route
    ) {

        composable(route = Screens.LoginScreen.route) {
            val loginViewModel: LoginViewModel = viewModel()
            LoginScreen(loginViewModel, navHostController)
        }

        composable(route = Screens.StaffScreen.route+"/{email}",
            arguments = listOf(navArgument("email") {
                type = NavType.StringType
            })
        ) {
           // Log.d("TAG", "args email: ${it.arguments?.getString("email")}")
            val staffViewModel: StaffViewModel = viewModel()
            StaffScreen(staffViewModel)
        }
    }
}