package com.example.compose.modules.login.stateexamples.g

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.compose.ui.commons.textField.CustomTextField
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun LoginScreen(
    viewModel: LoginViewModel
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {

        val email = viewModel.email.collectAsState()

        Column {
            CustomTextField(
                value = email.value,
                onValueChanged = {
                    viewModel.updateEmail(it)
                }, "Email"
            )
        }
    }
}


class LoginViewModel : ViewModel() {

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    fun updateEmail(newValue: String) {
        _email.value = newValue
    }
}