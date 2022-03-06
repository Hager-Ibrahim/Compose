package com.example.compose.modules.main.examples.first

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun EditTextExample() {
    TextField(
        value = "", onValueChange = {},
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(24.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF354b60),
            backgroundColor = Color(0xFFe1e5e9),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        )
    )
}