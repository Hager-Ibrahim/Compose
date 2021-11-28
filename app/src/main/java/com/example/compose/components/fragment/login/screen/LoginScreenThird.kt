package com.example.compose.components.fragment.login.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.compose.R
import com.example.compose.commons.presenration.button.DefaultButton
import com.example.compose.commons.presenration.imageView.ImageFromRes
import com.example.compose.commons.presenration.textField.AuthTextField
import com.example.compose.components.fragment.login.LoginViewModel

@Composable
fun LoginScreenThird(
    loginViewModel: LoginViewModel
) {
    val email = loginViewModel.email.collectAsState()
    val password = loginViewModel.password.observeAsState()

    Column() {
        ImageFromRes(
            R.drawable.login,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
        )
        AuthTextField(
            hint = "Email",
            email.value
        ) {
            loginViewModel.updateEmail(it)
        }
        AuthTextField(
            hint = "Password",
            password.value ?: ""
        ) {
            loginViewModel.updatePassword(it)
        }
        DefaultButton(buttonText = "Login") {}
    }
}