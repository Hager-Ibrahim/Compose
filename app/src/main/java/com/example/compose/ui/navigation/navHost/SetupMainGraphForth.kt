package com.example.compose.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
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
fun SetupMainNavGraphForth(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.LoginScreen.route
    ) {

        composable(route = Screens.LoginScreen.route) {
            val loginViewModel: LoginViewModel = viewModel()
            LoginScreen(loginViewModel, navHostController)
        }

        composable(route = Screens.StaffScreen.route,
            arguments = listOf(navArgument(EMAIL_KEY) {
                type = NavType.StringType
            })
        ) {
            Log.d("TAG", "args email: ${it.arguments?.getString(EMAIL_KEY)}")
            val staffViewModel: StaffViewModel = viewModel()
            StaffScreen(staffViewModel)
        }
    }
}