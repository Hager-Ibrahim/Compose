package com.example.compose.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text

@Composable
fun DefaultEditText(
    hint: String
) {
    TextField(
        value = "",
        onValueChange = {

        },
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp,bottom = 4.dp)
            .requiredHeight(50.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF354b60),
            backgroundColor = Color(0xFFe1e5e9),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ), placeholder = {
            Text(hint)
        }

    )
}
