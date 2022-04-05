package com.example.compose.modules.login.presentation.screen

data class LoginState(
    val phone: String? = null,
    val password: String? = null,
    val submitButtonEnabled: Boolean = false
)


// user actions
sealed class LoginEvent {
    data class ChangePhone(val phone: String) : LoginEvent()
    data class ChangePassword(val password: String) : LoginEvent()
    data class LoginClicked(val email: String, val password: String) : LoginEvent()
    data class showPassword(val showPassword: Boolean) : LoginEvent()
}


