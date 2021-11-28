package com.example.compose.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun TestRow() {
    Row() {
        Text(text = "One")
        Text(text = "Two")
    }
}