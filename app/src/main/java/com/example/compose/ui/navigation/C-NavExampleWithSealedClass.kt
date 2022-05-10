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
import com.example.compose.ui.navigation.ScreensC.*

@Preview
@Composable
fun PreviewNavExampleWithSealedClass() {
    val navController = rememberNavController()
    SetupNavGraphC(navController)
}
@Composable
fun SetupNavGraphC(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = MainScreenC.route){

        composable(route = MainScreenC.route){
            MainScreenC(navHostController)
        }

        composable(route = DetailsScreenC.route){
            DetailsScreenC()
        }
    }
}

sealed class ScreensC(val route: String) {
    object MainScreenC: ScreensC("main_screen")
    object DetailsScreenC: ScreensC("detail_screen")
}

@Composable
fun MainScreenC(navController: NavController) {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()) {

        Text("Main screen", Modifier.clickable {
            navController.navigate(route = DetailsScreenC.route)
        })
    }

}

@Composable
fun DetailsScreenC() {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()) {

        Text("Detail screen")
    }

}