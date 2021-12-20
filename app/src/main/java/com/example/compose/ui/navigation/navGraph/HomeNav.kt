package com.example.compose.ui.navigation.navGraph

import android.util.Log
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.example.compose.components.fragment.staff.StaffViewModel
import com.example.compose.components.fragment.staff.screen.StaffScreen
import com.example.compose.ui.navigation.EMAIL_KEY
import com.example.compose.ui.navigation.HOME_ROUTE
import com.example.compose.ui.navigation.PASSWORD_KEY
import com.example.compose.ui.navigation.Screens


fun NavGraphBuilder.homeNavGraph(){
    navigation(
        startDestination = Screens.StaffScreen.route,
        route= HOME_ROUTE
    ){
        composable(route = Screens.StaffScreen.route,
//            arguments = listOf(navArgument(EMAIL_KEY) {
//                type = NavType.StringType
//            }, navArgument(PASSWORD_KEY){
//                type = NavType.StringType
//                defaultValue=""
//            })
        ) {
//            Log.d("TAG", "args email: ${it.arguments?.getString(EMAIL_KEY)}")
//            Log.d("TAG", "args password: ${it.arguments?.getString(PASSWORD_KEY)}")

            val staffViewModel: StaffViewModel = viewModel()
            StaffScreen(staffViewModel)
        }
    }

}