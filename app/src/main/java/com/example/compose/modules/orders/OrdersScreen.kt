package com.example.compose.modules.orders

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.example.compose.ui.navigation.model.Screens
import com.example.compose.ui.navigation.navigate

@Composable
fun OrdersScreen(navController: NavHostController, viewModel: OrdersViewModel) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "ORDERS",
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.clickable {
               navController.navigate(Screens.OrderDetailsScreen.route)
            }
        )
    }
}

