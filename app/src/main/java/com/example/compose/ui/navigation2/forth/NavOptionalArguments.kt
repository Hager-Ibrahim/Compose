package com.example.compose.ui.navigation2.forth

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
import com.example.compose.ui.navigation2.forth.Screens.*

@Composable
fun SetupNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = MainScreen.route
    ) {

        composable(route = MainScreen.route) {
            MainScreen(navHostController)
        }

        composable(
            route = DetailsScreen.route,
            arguments = listOf(navArgument(DETAILS_ID_ARG) {
                type = NavType.IntType
            }, navArgument(NAME_ARG) {
                type = NavType.StringType
                defaultValue = ""
            })
        ) {
            DetailsScreen(
                it.arguments?.getInt(DETAILS_ID_ARG),
                it.arguments?.getString(NAME_ARG)
            )
        }
    }
}

const val DETAILS_ID_ARG = "id"
const val NAME_ARG = "name"

sealed class Screens(val route: String) {
    object MainScreen : Screens("main_screen")
    object DetailsScreen : Screens("detail_screen/{$DETAILS_ID_ARG}?$NAME_ARG={name}") {
        fun passId(id: Int): String =
            "detail_screen/$id"

        fun passIdAndName(id: Int, name: String? = ""): String =
            "detail_screen/$id?name=$name"
    }
}

@Composable
fun MainScreen(navController: NavController) {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {

        Text("Main screen", Modifier.clickable {
            //  navController.navigate(route =DetailsScreen.passId(8))
            navController.navigate(route = DetailsScreen.passIdAndName(8, "Hager"))

        })
    }

}

@Composable
fun DetailsScreen(id: Int?, name: String?) {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {

        Text("Detail screen id: $id  name: $name", fontSize = 12.sp)
    }

}