package com.example.compose.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun PreviewSetupNavBetweenScreens() {
    val navController = rememberNavController()
    SetupNavGraphB(navController)
}
@Composable
fun SetupNavGraphB(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = "main_screen"){

        composable(route = "main_screen"){
            MainScreenB(navHostController)
        }

        composable(route = "detail_screen"){
            DetailsScreenB()
        }
    }
}

@Composable
fun MainScreenB(navController: NavController) {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()) {

        Text("Main screen", Modifier.clickable {
            navController.navigate(route = "detail_screen")
        })
    }

}

@Composable
fun DetailsScreenB() {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()) {

        Text("Detail screen")
    }

}