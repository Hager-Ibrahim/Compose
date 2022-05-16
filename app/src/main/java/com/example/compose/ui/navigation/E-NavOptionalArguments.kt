package com.example.compose.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.compose.ui.navigation.ScreensE.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun PreviewNavOptionalArgument() {
    val navController = rememberNavController()
    SetupNavHostE(navController)
}
@Composable
fun SetupNavHostE(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = MainScreenE.route
    ) {

        composable(route = MainScreenE.route) {
            MainScreenE(navHostController)
        }

        composable(
            route = DetailsScreenE.route,
            arguments = listOf(navArgument(DETAILS_ID_ARGE) {
                type = NavType.IntType
            }, navArgument(NAME_ARG) {
                type = NavType.StringType
                defaultValue = ""
//                defaultValue = null
//                nullable = true
            })
        ) {
            DetailsScreenE(
                it.arguments?.getInt(DETAILS_ID_ARGE),
                it.arguments?.getString(NAME_ARG)
            )
        }
    }
}

const val DETAILS_ID_ARGE = "id"
const val NAME_ARG = "name"

sealed class ScreensE(val route: String) {
    object MainScreenE : ScreensE("main_screen")
    object DetailsScreenE : ScreensE("detail_screen/{$DETAILS_ID_ARGE}?$NAME_ARG={name}") {
        fun passId(id: Int): String =
            "detail_screen/$id"

        fun passIdAndName(id: Int, name: String? = ""): String =
            "detail_screen/$id?name=$name"
    }
}

@Composable
fun MainScreenE(navController: NavController) {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {

        Text("Main screen", Modifier.clickable {
            //  navController.navigate(route =DetailsScreenE.passId(8))
            navController.navigate(route = DetailsScreenE.passIdAndName(8, "Hager"))

        })
    }

}

@Composable
fun DetailsScreenE(id: Int?, name: String?) {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {

        Text("Detail screen id: $id  name: $name", fontSize = 18.sp)
    }

}