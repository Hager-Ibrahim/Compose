package com.example.compose.components.fragment.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController



@Composable
fun MainScreen(navController: NavController) {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()) {

        Text("Main screen", Modifier.clickable {
            navController.navigate(route = "detail_screen")
        })
    }

}

@Composable
fun DetailScreen() {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()) {

        Text("Detail screen")
    }

}