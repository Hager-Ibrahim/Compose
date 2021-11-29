package com.example.compose.commons.presenration.text

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.TextUnit

@Composable
fun DefaultText(
    text: String,
    color: Color,
    fontSize: TextUnit,
    modifier: Modifier? = Modifier
) {
    Text(
        text = text,
        color = color,
        fontSize = fontSize,
        modifier = modifier ?: Modifier
            .wrapContentHeight()
            .wrapContentWidth()
    )
}