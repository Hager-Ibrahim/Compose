package com.example.compose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.compose.R
import com.example.compose.components.ui.AuthTextField
import com.example.compose.components.ui.DefaultButton
import com.example.compose.components.ui.DefaultTextField
import com.example.compose.components.ui.ImageFromRes

@Composable
fun MainScreenSecond() {
    Column() {
        ImageFromRes(
            R.drawable.login,
            modifier = Modifier.fillMaxWidth())
        AuthTextField(hint = "Email")
        AuthTextField(hint = "Password")
        DefaultButton(buttonText = "Login") {}
    }
}