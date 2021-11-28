package com.example.compose.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DefaultButton(
    buttonText: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 24.dp,
                end = 24.dp,
                bottom = 50.dp,
                top = 4.dp )
            .requiredHeight(50.dp)
        ,colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color(0xFF354b60),
            contentColor = Color.White
        )
    ) { Text(text = buttonText) }

}