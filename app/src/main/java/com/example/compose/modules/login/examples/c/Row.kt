package com.example.compose.modules.login.examples.c

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun LoginScreen() {
    Row() {
        Text(text = "One")
        Text(text = "Two")
    }
}