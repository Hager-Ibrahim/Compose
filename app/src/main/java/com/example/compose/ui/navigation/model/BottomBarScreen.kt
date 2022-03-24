package com.example.compose.ui.navigation.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomBarScreen(
     val title: String,
    val icon: ImageVector,
    val route: String
) {
    Home("Home", Icons.Default.Home, "home"),
    Orders("Orders", Icons.Default.Person, "order"),
    Settings("Settings", Icons.Default.Settings, "settings"),
}