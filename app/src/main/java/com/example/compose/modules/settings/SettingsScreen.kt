package com.example.compose.modules.settings

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.compose.modules.orders.OrdersViewModel

@Composable
fun SettingsScreen(viewModel: SettingsViewModel) {
    DisposableEffect(key1 = viewModel) {
        Log.d("TEST", "SettingsScreen: Start")
        onDispose {
            Log.d("TEST", "SettingsScreen: Stop")
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "SETTINGS",
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}