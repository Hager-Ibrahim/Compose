package com.example.compose.ui.navigation.navGraph

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.compose.modules.home.HomeScreen
import com.example.compose.modules.home.HomeViewModel
import com.example.compose.modules.orders.OrdersScreen
import com.example.compose.modules.orders.OrdersViewModel
import com.example.compose.modules.settings.SettingsScreen
import com.example.compose.modules.settings.SettingsViewModel
import com.example.compose.ui.navigation.model.BottomBarScreen.*

fun NavGraphBuilder.bottomNavGraph(navController: NavHostController) {

        composable(route = Home.route) {
            val viewModel: HomeViewModel = viewModel()
            HomeScreen(viewModel)
        }
        composable(route = Orders.route) {
            val viewModel: OrdersViewModel = viewModel()
            OrdersScreen(navController, viewModel)
        }
        composable(route = Settings.route) {
            val viewModel: SettingsViewModel = viewModel()
            SettingsScreen(viewModel)
        }

}