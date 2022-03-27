package com.example.compose.modules.login.alignment.e

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
 * Arrangement.SpaceBetween:
 * places first item in the main axis start and the last item
 * in the main axis end, then distribute the remaining items
 * evenly in the space left.
 */
@Preview("Space between")
@Composable
fun AlignmentExample() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(BorderStroke(1.dp, color = Color.Gray)),
        horizontalArrangement = Arrangement.SpaceBetween,
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

@Preview("Weight")
@Composable
fun AlignmentExampleWeight() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(BorderStroke(1.dp, color = Color.Gray)),
//        horizontalArrangement = Arrangement.SpaceBetween,
//        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Test1",
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.background(Color.Gray).weight(1F)
        )

        Text(
            text = "Test2",
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.background(Color.Red).weight(1F)
        )

        Text(
            text = "Test3",
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.background(Color.Yellow).weight(1F)
        )
    }
}