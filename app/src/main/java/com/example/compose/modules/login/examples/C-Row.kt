package com.example.compose.modules.login.examples

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun RowExample() {
    Row() {
        Text(text = "One", fontSize = 20.sp)
        Text(text = "Two",fontSize = 20.sp)
    }
}