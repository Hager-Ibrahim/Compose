package com.example.compose.modules.login.stateexamples


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.compose.ui.commons.textField.CustomTextField
import androidx.lifecycle.ViewModel

//stateful
@Composable
fun LoginScreen(viewModel: LoginViewModel2){
    val email = viewModel.email.observeAsState()

    LoginContent(email.value?:""){
        viewModel.updateEmail(it)
    }
}
// stateless
@Composable
fun LoginContent(
     email: String,
     onEmailChanged: (String)-> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column {

            CustomTextField(
                value = email ,
                onValueChanged = {
                    onEmailChanged(it)
                }, "Email"
            )
        }
    }
}

class LoginViewModel2 : ViewModel() {


    private val _email = MutableLiveData<String>()
    val email: LiveData<String>
        get() = _email

    fun updateEmail(newValue: String) {
        _email.value = newValue
    }
}

@Preview
@Composable
fun StateHoistingPreview() {
    val viewModel = LoginViewModel2()
    LoginScreen(viewModel)
}