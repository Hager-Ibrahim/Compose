package com.example.compose.ui.navigation

import android.os.Bundle
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
import com.example.compose.modules.staff.model.StaffUIModel
import com.example.compose.ui.navigation.ScreensF.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.compose.ui.helper.getParcelable
import com.example.compose.ui.helper.navigate

@Preview
@Composable
fun PreviewParcelableExample() {
    val navController = rememberNavController()
    SetupNavHostF(navController)
}
@Composable
fun SetupNavHostF(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = MainScreen.route){

        composable(route = MainScreen.route){
            MainScreen(navHostController)
        }

        composable(
            route = DetailsScreen.route,
            arguments = listOf(navArgument(DETAILS_ID_ARGF) {
                type = NavType.IntType
            })){
            DetailsScreen(it.arguments?.getInt(DETAILS_ID_ARGF), it.getParcelable(STAFF_ARG) as Bundle)
        }
    }
}

private const val DETAILS_ID_ARGF="id"
sealed class ScreensF(val route: String) {
    object MainScreen: ScreensF("main_screen")
    object DetailsScreen: ScreensF("detail_screen/{${DETAILS_ID_ARGF}}"){
        fun passId(id: Int): String =
            "detail_screen/$id"
    }
}

const val STAFF_ARG="staff_bundle"
const val STAFF_KEY="staff_key"

@Composable
private fun MainScreen(navController: NavController) {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()) {

        Text("Main screen", Modifier.clickable {
            val args = Bundle()
            val staff = StaffUIModel(9,"","","",true,"")
            args.putParcelable(STAFF_KEY, staff)
            navController.navigate(route =DetailsScreen.passId(8),  STAFF_ARG to args)
        })
    }

}

@Composable
private fun DetailsScreen(id: Int?, bundle: Bundle) {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()) {

        val staff = bundle.getParcelable<StaffUIModel>(STAFF_KEY)

        Text("Detail screen  $id".plus("\n \n").plus(staff), fontSize = 18.sp)
    }

}