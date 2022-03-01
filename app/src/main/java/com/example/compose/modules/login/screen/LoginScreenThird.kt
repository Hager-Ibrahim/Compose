package com.example.compose.modules.login.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.compose.R
import com.example.compose.modules.login.stateexamples.forth.LoginViewModel
import com.example.compose.ui.commons.button.DefaultButton
import com.example.compose.ui.commons.imageView.ImageFromRes
import com.example.compose.ui.commons.textField.AuthTextField

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