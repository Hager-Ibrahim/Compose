package com.example.compose.modules.login.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.ui.commons.AuthTextField
import com.example.compose.ui.commons.DefaultButton

@Preview
@Composable
fun AddColumn() {
    Column() {
        AuthTextField(hint = "")
        DefaultButton(buttonText = "Login") {}
    }

}