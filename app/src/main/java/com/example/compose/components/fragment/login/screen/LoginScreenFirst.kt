package com.example.compose.components.fragment.login.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.compose.R
import com.example.compose.commons.presenration.textField.AuthTextField
import com.example.compose.commons.presenration.button.DefaultButton
import com.example.compose.commons.presenration.imageView.ImageFromRes

@Composable
fun LoginScreenFirst(

) {
    Column() {
        ImageFromRes(
            R.drawable.login,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
        )
        AuthTextField(hint = "Email", "") {

        }
        AuthTextField(hint = "Password", "") {

        }
        DefaultButton(buttonText = "Login") {}
    }
}