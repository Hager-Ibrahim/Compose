package com.example.compose.modules.login.stateexamples.e


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData

import androidx.lifecycle.MutableLiveData
import com.example.compose.ui.commons.textField.StateTextField
import androidx.lifecycle.ViewModel
import com.example.compose.modules.login.stateexamples.g.LoginViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {

        val email = viewModel.email.observeAsState()

        Column {


            StateTextField(
                value = email.value ?:"",
                onValueChanged = {
                    viewModel.updateEmail(it)
                }, "Email"
            )
        }
    }
}

class LoginViewModel : ViewModel() {


    private val _email = MutableLiveData<String>()
    val email: LiveData<String>
        get() = _email

    fun updateEmail(newValue: String) {
        _email.value = newValue
    }
}