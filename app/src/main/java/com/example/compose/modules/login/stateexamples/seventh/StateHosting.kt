package com.example.compose.modules.login.stateexamples.seventh

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.compose.ui.commons.button.DefaultButton
import com.example.compose.ui.commons.textField.StateTextField
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    val email = viewModel.email.collectAsState()
    val password = viewModel.password.observeAsState()
    val updatePassword: (text: String) -> Unit = remember {
        { viewModel.updatePassword(it) }
    }
    val updateEmail: (text: String) -> Unit = remember {
        { viewModel.updateEmail(it) }
    }
    LoginContent(
        email = email.value,
        password = password.value ?: "",
        onEmailChanged = updateEmail,
        onPasswordChanged = updatePassword
    )

}

@Composable
fun LoginContent(
    email: String,
    password: String,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {

        Column {

            StateTextField(
                value = email,
                onValueChanged = {
                    onEmailChanged(it)
                }, "Email"
            )

            Spacer(modifier = Modifier.padding(4.dp))

            StateTextField(
                value = password,
                onValueChanged = {
                    onPasswordChanged(it)
                }, "Password"
            )

            Spacer(modifier = Modifier.padding(12.dp))
            DefaultButton("Login") {

            }

        }
    }
}


class LoginViewModel : ViewModel() {


    private val _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()


    fun updatePassword(newValue: String) {
        _password.value = newValue
    }

    fun updateEmail(newValue: String) {
        _email.value = newValue
    }
}