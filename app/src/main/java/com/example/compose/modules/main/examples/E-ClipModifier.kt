package com.example.compose.modules.main.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ClipModifierExample() {
    Text(
        text = "Text with Clipped background",
        color = Color.White,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(10.dp)
            .border(2.dp, Color.Red,RoundedCornerShape(24.dp))
            .clip(RoundedCornerShape(24.dp))
            .background(Color.Blue)
            .padding(16.dp)
    )
}