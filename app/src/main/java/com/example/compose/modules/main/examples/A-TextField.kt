package com.example.compose.modules.main.examples

import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun TextFieldExample() {
    TextField(
        value = "Text Field",
        onValueChange = {

        },
    )
}