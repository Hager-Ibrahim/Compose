package com.example.compose.modules.login.alignment.f

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
Arrangement.SpaceEvenly:
puts the same amount of space between items,
the start and the end. It differentiates from space around
because the spacing in start and end is the same as the spacing
in the middle
 */

@Preview
@Composable
fun AlignmentExample() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(BorderStroke(1.dp, color = Color.Gray)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Test1",
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.background(Color.Gray)
        )

        Text(
            text = "Test2",
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.background(Color.Red)
        )

        Text(
            text = "Test3",
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.background(Color.Yellow)
        )
    }
}