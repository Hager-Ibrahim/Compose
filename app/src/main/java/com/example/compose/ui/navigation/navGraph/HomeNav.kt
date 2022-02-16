package com.example.compose.ui.navigation.navGraph

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.compose.components.fragment.staff.StaffViewModel
import com.example.compose.components.fragment.staff.screen.StaffScreen
import com.example.compose.ui.navigation.HOME_ROUTE
import com.example.compose.ui.navigation.Screens


fun NavGraphBuilder.homeNavGraph(){
    navigation(
        startDestination = Screens.StaffScreen.route,
        route= HOME_ROUTE
    ){
        composable(route = Screens.StaffScreen.route,
        ) {
            val staffViewModel: StaffViewModel = viewModel()
            StaffScreen(staffViewModel)
        }
    }

}