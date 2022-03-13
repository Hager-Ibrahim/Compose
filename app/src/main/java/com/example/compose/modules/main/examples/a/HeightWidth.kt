package com.example.compose.modules.main.examples.a

import androidx.compose.foundation.layout.*
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ModifierExample() {
    TextField(
        value = "", onValueChange = {},
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(24.dp),
    )
}

@Preview(showBackground = true)
@Composable
fun FixedHeightWidthExample() {
    TextField(
        value = "", onValueChange = {},
        Modifier
            .height(100.dp)
            .width(200.dp)
            .padding(24.dp),
    )
}