package com.example.compose.modules.main.examples.c

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun PaddingExample() {
    Text(
        text = "Hello World!",
        color = Color.Gray,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(16.dp) // margin
            .border(4.dp, Color.Red) // outer border
            .padding(16.dp) // space between the borders
            .border(4.dp, Color.Green) // inner border
            .padding(16.dp)// padding
        , fontSize = 30.sp
    )
}