package com.example.compose.modules.login.stateexamples.j


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.*
import com.example.compose.R
import com.example.compose.ui.commons.textField.NormalTextField
import com.example.compose.ui.commons.textField.PasswordTextField
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    val loginState by viewModel.state.collectAsState()

    var passwordVisibility by remember { mutableStateOf(false) }


    Column() {

        PasswordTextField(
            text = loginState.password,
            hint = stringResource(id = R.string.password),
            isPasswordVisible = passwordVisibility,
            onValueChanged = { viewModel.updatePassword(it) },
            onPasswordIconClicked = {
                passwordVisibility = !passwordVisibility
            })

        NormalTextField(
            text = loginState.email,
            hint = stringResource(id = R.string.phone),
            onValueChanged = { viewModel.updateEmail(it) },
            keyboardOptions  = KeyboardOptions(
                keyboardType= KeyboardType.Text,
                imeAction = ImeAction.Done)
        )

        Button(
            onClick = { /*TODO*/ },
            enabled = loginState.submitButtonEnabled
        ) {
            Text(text = stringResource(id = R.string.app_name))
        }

    }
}



class LoginViewModel : ViewModel() {

    private val initialState: LoginState by lazy { LoginState() }

    private val _state = MutableStateFlow(initialState)
    val state get() = _state.asStateFlow()

    private val _event = MutableSharedFlow<LoginEvent>()
    private val event get() = _event.asSharedFlow()

    init {
        subscribeEvents()
    }


    private fun subscribeEvents() {
        viewModelScope.launch {
            event.collect {
                when (it) {
                    is LoginEvent.EmailChange ->
                        _state.value = _state.value.copy(
                            email = it.newValue,
                            submitButtonEnabled = it.newValue.isNotEmpty()
                                    && _state.value.password?.isNotEmpty() == true
                        )
                    is LoginEvent.PasswordChange ->
                        _state.value = _state.value.copy(
                            password = it.newValue,
                            submitButtonEnabled = it.newValue.isNotEmpty()
                                    && _state.value.email?.isNotEmpty() == true
                        )

                    else -> {}
                }
            }
        }
    }

    private fun setEvent(event: LoginEvent) {
        viewModelScope.launch {
            _event.emit(event)
        }
    }


    fun updateEmail(newValue: String) {
        setEvent(
            LoginEvent.EmailChange(
                newValue
            )
        )
    }

    fun updatePassword(newValue: String) {
        setEvent(
            LoginEvent.PasswordChange(
                newValue
            )
        )
    }
}

@Preview
@Composable
fun PreviewPasswordEditText() {
    PasswordTextField(text = "", "", true, { }, {})
}