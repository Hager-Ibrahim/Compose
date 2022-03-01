package com.example.compose.modules.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose.ui.commons.livedata.Event
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: State<Boolean> get() = _isLoading

    private val _navigate = MutableLiveData<Event<Unit>>()
    val navigate: LiveData<Event<Unit>>
        get() = _navigate


    fun updatePassword(newValue: String) {
        _password.value = newValue
    }

    fun updateEmail(newValue: String) {
        _email.value = newValue
    }

    fun fakeNetworkCall() {
        viewModelScope.launch {
            _isLoading.value = true
            delay(2000)
            _isLoading.value = false
            _navigate.postValue(Event(Unit))
        }

    }

}