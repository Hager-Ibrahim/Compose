package com.example.compose.ui.navigation.model



const val AUTH_ROUTE="auth"
const val HOME_ROUTE="home"


sealed class Screens(val route: String) {
    object LoginScreen: Screens("login")
    object MainScreen: Screens("main")
}