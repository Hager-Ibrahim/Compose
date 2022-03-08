package com.example.compose.modules.login.alignment.sixth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Arrangement.SpaceAround:
 * puts the same amount of space in the left and the right of each item
 * (in a Row, or top and bottom in a Column)
 *.Notice that spaces in the middle will be twice as large as
 * spaces in the ends.
 */

@Preview
@Composable
fun AlignmentExample() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .border(BorderStroke(1.dp, color = Color.Gray)),
        verticalArrangement = Arrangement.SpaceAround,
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