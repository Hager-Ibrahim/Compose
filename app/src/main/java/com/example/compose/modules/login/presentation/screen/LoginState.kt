package com.example.compose.modules.login.presentation.screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.compose.ui.commons.textField.ErrorTextFieldState

data class LoginState(
    val phone: BaseTextFieldState = BaseTextFieldState(),
    val password: BaseTextFieldState = BaseTextFieldState(),
    val showPassword: Boolean = false
)


// user actions
sealed class LoginEvent {
    data class ChangePhone(val phone: String) : LoginEvent()
    data class ChangePassword(val password: String) : LoginEvent()
    data class LoginClicked(val email: String, val password: String) : LoginEvent()
    object ShowPassword : LoginEvent()
}

data class BaseTextFieldState(
    val initialText: String? = null,
) {

    val isValid = initialText?.isNotEmpty() ?: false

}

