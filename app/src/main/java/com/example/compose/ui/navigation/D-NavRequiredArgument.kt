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
import com.example.compose.ui.navigation.ScreensD.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController


@Preview
@Composable
fun PreviewNavRequiredArgument() {
    val navController = rememberNavController()
    SetupNavHostD(navController)
}

@Composable
fun SetupNavHostD(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = MainScreenD.route){

        composable(route = MainScreenD.route){
            MainScreenD(navHostController)
        }

        composable(
            route = DetailsScreenD.route,
            arguments = listOf(navArgument(DETAILS_ID_ARG) {
                type = NavType.IntType
            })){
            DetailsScreenD(it.arguments?.getInt(DETAILS_ID_ARG))
        }
    }
}

const val DETAILS_ID_ARG="id"
sealed class ScreensD(val route: String) {
    object MainScreenD: ScreensD("main_screen")
    object DetailsScreenD: ScreensD("detail_screen/{${DETAILS_ID_ARG}}"){
        fun passId(id: Int): String =
            "detail_screen/$id"
    }
}

@Composable
fun MainScreenD(navController: NavController) {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()) {

        Text(
            "Main screen",
            fontSize =20.sp,
            modifier= Modifier.clickable {
            navController.navigate(route =DetailsScreenD.passId(8))
        })
    }

}

@Composable
fun DetailsScreenD(id: Int?) {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()) {

        Text("Detail screen  $id", fontSize = 18.sp)
    }

}