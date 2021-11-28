package com.example.compose.components.alignment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun TestAlignmentsFinal(

) {
    Column(

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = "Test",
            fontSize = 14.sp,
        )

        Text(
            text = "Test",
            fontSize = 14.sp,
        )

        Text(
            text = "Test",
            fontSize = 14.sp,
        )
    }
}