package com.example.compose.modules.login.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.R
import com.example.compose.modules.login.presentation.LoginViewModel
import com.example.compose.ui.commons.textField.NormalTextField
import com.example.compose.ui.commons.textField.PasswordTextField

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    val loginState by viewModel.state.collectAsState(LoginState())

    LoginContent(
        password = loginState.password,
        phone = loginState.phone,
        passwordVisibility = loginState.showPassword,
        submitButtonEnabled = loginState.submitButtonEnabled,
        onPhoneChanged = viewModel::updatePhone,
        onPasswordChanged = viewModel::updatePassword,
        updatePasswordVisibility = viewModel::updatePasswordVisibility,
    )

}

@Composable
fun LoginContent(
    password: String?,
    phone: String?,
    passwordVisibility: Boolean,
    submitButtonEnabled: Boolean,
    onPhoneChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    updatePasswordVisibility: () -> Unit,
) {
    Column {

        PasswordTextField(
            text = password,
            hint = stringResource(id = R.string.password),
            isPasswordVisible = passwordVisibility,
            onValueChanged = {
                onPasswordChanged(it)
            },
            onPasswordIconClicked = {
                updatePasswordVisibility()
            }, keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ))

        NormalTextField(
            text = phone,
            hint = stringResource(id = R.string.phone),
            onValueChanged = { onPhoneChanged(it) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Done
            )
        )

        Button(
            onClick = { /*TODO*/ },
            enabled = submitButtonEnabled
        ) {
            Text(text = stringResource(id = R.string.app_name))
        }

    }
}



@Preview
@Composable
fun PreviewPasswordEditText() {
    PasswordTextField(text = "", "", true, KeyboardOptions(
        keyboardType = KeyboardType.Number,
        imeAction = ImeAction.Done
    ),{ }, {}, )
}