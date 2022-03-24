package com.example.compose.ui.navigation.model



const val HOME_ROUTE="home"


sealed class Screens(val route: String) {
    object MainScreen: Screens("main")
    object OrderDetailsScreen: Screens("profile_details")
}