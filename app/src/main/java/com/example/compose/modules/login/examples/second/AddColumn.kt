package com.example.compose.modules.login.examples.second

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.ui.commons.AuthTextField
import com.example.compose.ui.commons.DefaultButton

@Preview
@Composable
fun LoginScreen() {
    Column() {
        AuthTextField(hint = "")
        DefaultButton(buttonText = "Login") {}
    }

}