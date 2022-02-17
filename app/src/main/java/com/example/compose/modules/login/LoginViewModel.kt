package com.example.compose.modules.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.*

class LoginViewModel: ViewModel() {
    private val _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    fun updatePassword(newValue: String){
        _password.value = newValue
    }

    fun updateEmail(newValue: String){
        _email.value = newValue
    }

}