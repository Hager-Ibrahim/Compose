package com.example.compose.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = "main_screen"){

        composable(route = "main_screen"){
            MainScreen()
        }

        composable(route = "detail_screen"){
            DetailsScreen()
        }
    }
}

@Composable
private fun MainScreen() {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()) {

        Text("Main screen", Modifier.clickable {

        })
    }

}

@Composable
private fun DetailsScreen() {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()) {

        Text("Detail screen")
    }

}