package com.example.compose.modules.main.examples.b

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
        value = "",
        onValueChange = {},
        modifier =
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun FixedHeightWidthExample() {
    TextField(
        value = "", onValueChange = {},
        Modifier
            .requiredHeight(100.dp)
            .requiredWidth(200.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun MaxHeightWidthExample() {
    TextField(
        value = "", onValueChange = {},
        Modifier.fillMaxSize()
    //Modifier.fillMaxHeight().fillMaxWidth()
    )
}