package com.example.compose.ui.navigationexamples.second

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose.ui.navigationexamples.second.Screens.*

@Composable
fun SetupNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = MainScreen.route){

        composable(route = MainScreen.route){
            MainScreen(navHostController)
        }

        composable(route = DetailsScreen.route){
            DetailsScreen()
        }
    }
}

sealed class Screens(val route: String) {
    object MainScreen: Screens("main_screen")
    object DetailsScreen: Screens("detail_screen")
}

@Composable
fun MainScreen(navController: NavController) {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()) {

        Text("Main screen", Modifier.clickable {
            navController.navigate(route = DetailsScreen.route)
        })
    }

}

@Composable
fun DetailsScreen() {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()) {

        Text("Detail screen")
    }

}