package com.example.compose.modules.main.examples.b

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.ui.theme.DarkGray
import com.example.compose.ui.theme.LightGray

@Preview
@Composable
fun ModifierExample() {
    TextField(
        value = "", onValueChange = {},
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            //.padding(24.dp)
        ,
        colors = TextFieldDefaults.textFieldColors(
            textColor = DarkGray,
            backgroundColor = LightGray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        )
    )
}