package com.example.compose.modules.main.examples.second

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.R
import com.example.compose.ui.commons.AuthTextField
import com.example.compose.ui.commons.DefaultButton
import com.example.compose.ui.commons.ImageFromRes

@Preview
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