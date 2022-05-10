package com.example.compose.modules.staff.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.commons.text.DefaultText

@Composable
fun StaffHeader() {
    DefaultText(
        text = "Staff",
        color = Color(0xFF34495e),
        fontSize = 22.sp,
        Modifier.fillMaxSize().background(Color.White).padding(8.dp)
    )
}