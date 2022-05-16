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
import com.example.compose.ui.navigation.Screens.*

@Preview
@Composable
fun PreviewNavExampleWithSealedClass() {
    val navController = rememberNavController()
    SetupNavHostC(navController)
}
@Composable
fun SetupNavHostC(navHostController: NavHostController) {
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
private fun MainScreen(navController: NavController) {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()) {

        Text("Main screen", Modifier.clickable {
            navController.navigate(route = DetailsScreen.route)
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