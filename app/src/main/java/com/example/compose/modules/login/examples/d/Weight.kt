package com.example.compose.modules.login.examples.d

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.compose.R
import com.example.compose.ui.commons.AuthTextField
import com.example.compose.ui.commons.DefaultButton
import com.example.compose.ui.commons.ImageFromRes

@Composable
fun LoginScreen() {
    Column() {
        ImageFromRes(
            R.drawable.login,
            modifier = Modifier.fillMaxWidth().weight(1F))
        AuthTextField(hint = "Email")
        AuthTextField(hint = "Password")
        DefaultButton(buttonText = "Login") {}
    }
}