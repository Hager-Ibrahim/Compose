package com.example.compose.modules.login.alignment.e

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Arrangement.SpaceBetween:
 * places first item in the main axis start and the last item
 * in the main axis end, then distribute the remaining items
 * evenly in the space left.
 */
@Preview
@Composable
fun AlignmentExample() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(200.dp)
            .border(BorderStroke(1.dp, color = Color.Gray)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = "Test1",
            fontSize = 18.sp,
            color = Color.White
        )

        Text(
            text = "Test2",
            fontSize = 18.sp,
            color = Color.White
        )

        Text(
            text = "Test3",
            fontSize = 18.sp,
            color = Color.White
        )
    }
}