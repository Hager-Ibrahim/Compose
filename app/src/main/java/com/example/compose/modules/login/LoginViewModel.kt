package com.example.compose.modules.login

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    private val _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: State<Boolean> get() = _isLoading


    fun updatePassword(newValue: String){
        _password.value = newValue
    }

    fun updateEmail(newValue: String){
        _email.value = newValue
    }

    fun fakeNetworkCall(){
        viewModelScope.launch {
            _isLoading.value = true
            delay(4000)
            Log.d("TAG", "fakeNetworkCall: ")
            _isLoading.value = false
        }

    }

}