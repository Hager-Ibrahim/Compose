package com.example.compose.modules.login.stateexamples


import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ui.commons.button.DefaultButton
import com.example.compose.ui.commons.textField.CustomTextField

@Preview
@Composable
fun RecompositionExample() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Log.d("TEST STATE", "LoginScreen: ")

        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }

        Column {

            Email(email = email.value,
                onEmailChanged = { email.value = it })

            Spacer(modifier = Modifier.padding(4.dp))

            Password(password = password.value, onPasswordChanged = { password.value = it })

            Spacer(modifier = Modifier.padding(4.dp))

            Button()

        }
    }
}

@Composable
fun Email(
    email: String,
    onEmailChanged: (String) -> Unit,
) {
    Log.d("TEST STATE", "Email: ")

    CustomTextField(
        value = email,
        onValueChanged = {
            onEmailChanged(it)
        }, "Email"
    )
}

@Composable
fun Password(
    password: String,
    onPasswordChanged: (String) -> Unit,
) {
    Log.d("TEST STATE", "Password: ")

    CustomTextField(
        value = password,
        onValueChanged = {
            onPasswordChanged(it)
        }, "Password"
    )
}

@Composable
fun Button() {
    Log.d("TEST STATE", "Button: ")

    DefaultButton("Login") {

    }
}
