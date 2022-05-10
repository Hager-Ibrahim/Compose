package com.example.compose.modules.login.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.ui.commons.AuthTextField
import com.example.compose.ui.commons.DefaultButton
import com.example.compose.ui.commons.ImageFromRes

@Preview
@Composable
fun LoginScreen() {
    Column() {
        ImageFromRes(
            modifier = Modifier.fillMaxWidth().weight(1F))
        AuthTextField(hint = "Email")
        AuthTextField(hint = "Password")
        DefaultButton(buttonText = "Login") {}
    }
}