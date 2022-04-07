package com.example.compose.modules.login.presentation.screen

import android.content.Context
import com.example.compose.ui.commons.enums.TextInputValidator


data class LoginState(
    val phone: BaseTextFieldState = BaseTextFieldState(inputValidator = TextInputValidator.PhoneNumberValidator()),
    val password: BaseTextFieldState = BaseTextFieldState(inputValidator = TextInputValidator.OldPasswordValidator()),
    val showPassword: Boolean = false
)


// user actions
sealed class LoginEvent {
    data class ChangePhone(val phone: String) : LoginEvent()
    data class ChangePassword(val password: String) : LoginEvent()
    data class Login(val email: String?, val password: String?) : LoginEvent()
    object ShowPassword : LoginEvent()
}

data class BaseTextFieldState(
    val text: String? = null,
    var inputValidator: TextInputValidator,
) {
    fun isValid(context: Context)= inputValidator.isValid(text?:"")?.getString(context) == null
   // fun getErrorMessage(context: Context) = inputValidator.isValid(initialText?:"")?.getString(context)
}

