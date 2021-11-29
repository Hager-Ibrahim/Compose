package com.example.compose.commons.presenration.shapes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


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
