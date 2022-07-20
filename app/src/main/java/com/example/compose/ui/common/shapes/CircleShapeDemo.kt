package com.example.compose.ui.theme.presenration.shapes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.Dp


@Composable
fun DefaultShape(
    shape: Shape,
    size: Dp,
    color: Color,
    layoutId: String?= "") {
    Box(
        modifier = Modifier
            .size(size)
            .clip(shape)
            .background(color)
            .layoutId(layoutId?:"")
    )
}
