package com.example.compose.ui.navigationexamples.d

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose.ui.navigationexamples.d.Screens.*

@Composable
fun SetupNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = MainScreen.route){

        composable(route = MainScreen.route){
            MainScreen(navHostController)
        }

        composable(
            route = DetailsScreen.route,
            arguments = listOf(navArgument(DETAILS_ID_ARG) {
                type = NavType.IntType
            })){
            DetailsScreen(it.arguments?.getInt(DETAILS_ID_ARG))
        }
    }
}

const val DETAILS_ID_ARG="id"
sealed class Screens(val route: String) {
    object MainScreen: Screens("main_screen")
    object DetailsScreen: Screens("detail_screen/{${DETAILS_ID_ARG}}"){
        fun passId(id: Int): String =
            "detail_screen/$id"
    }
}

@Composable
fun MainScreen(navController: NavController) {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()) {

        Text("Main screen", Modifier.clickable {
            navController.navigate(route =DetailsScreen.passId(8))
        })
    }

}

@Composable
fun DetailsScreen(id: Int?) {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()) {

        Text("Detail screen  $id", fontSize = 18.sp)
    }

}