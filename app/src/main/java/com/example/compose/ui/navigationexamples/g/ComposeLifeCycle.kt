package com.example.compose.ui.navigationexamples.g

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose.ui.navigationexamples.c.Screens.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@Composable
fun SetupNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = MainScreen.route
    ) {

        composable(route = MainScreen.route) {
            val viewModel: MainViewModel = viewModel()

            MainScreen(navHostController, viewModel)
        }

        composable(route = DetailsScreen.route) {
            DetailsScreen()
        }
    }
}


@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {

        DisposableEffect(key1 = viewModel) {
            viewModel.onStart()
            onDispose { viewModel.onStop() }
        }

        Text("Main screen", Modifier.clickable {
            navController.navigate(route = DetailsScreen.route)
        })
    }

}
@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    fun onStart() {
        Log.d("TAG", "onStart: ")

        // start task - the composable has entered the composition
    }

    fun onStop() {
        Log.d("TAG", "onStop: ")

        // cancel task - the composable has left the composition
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TAG", "onCleared: ")

    }
}

sealed class Screens(val route: String) {
    object MainScreen : Screens("main_screen")
    object DetailsScreen : Screens("detail_screen")
}

@Composable
fun DetailsScreen() {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {

        Text("Detail screen")
    }

}