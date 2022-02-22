package com.example.compose.modules.login.stateexamples.forth

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.compose.ui.commons.textField.AuthTextField
import com.example.compose.modules.login.LoginViewModel
import com.example.compose.ui.commons.visible

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    onClick: ()-> Unit
) {
    val email = loginViewModel.email.collectAsState()
    val password = loginViewModel.password.observeAsState()
    val isLoading: Boolean by loginViewModel.isLoading
    Log.d("TAG", "onCreateView: 22222")


    Column() {
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

        Button(onClick = { onClick() }) {
            Text(text = "login")
        }

        CircularProgressIndicator(Modifier.visible(isLoading))
        
    }
}