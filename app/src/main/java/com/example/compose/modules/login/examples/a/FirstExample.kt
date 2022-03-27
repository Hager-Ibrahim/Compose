package com.example.compose.modules.login.examples.a

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.ui.commons.AuthTextField
import com.example.compose.ui.commons.DefaultButton

@Preview
@Composable
fun LoginScreen() {
    AuthTextField(hint = "Name")
    DefaultButton(buttonText = "Login") {}
}