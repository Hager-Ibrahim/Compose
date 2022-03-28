package com.example.compose.ui.navigation.b

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

@Composable
fun SetupNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = "main_screen"){

        composable(route = "main_screen"){
            MainScreen(navHostController)
        }

        composable(route = "detail_screen"){
            DetailsScreen()
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()) {

        Text("Main screen", Modifier.clickable {
            navController.navigate(route = "detail_screen")
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