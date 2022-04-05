package com.example.compose.modules.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose.modules.login.presentation.screen.LoginEvent
import com.example.compose.modules.login.presentation.screen.LoginState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

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
                    is LoginEvent.ChangePhone ->
                        _state.value = _state.value.copy(
                            phone = it.phone,
                            submitButtonEnabled = it.phone.isNotEmpty()
                                    && _state.value.password?.isNotEmpty() == true
                        )
                    is LoginEvent.ChangePassword ->
                        _state.value = _state.value.copy(
                            password = it.password,
                            submitButtonEnabled = it.password.isNotEmpty()
                                    && _state.value.phone?.isNotEmpty() == true
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


    fun updatePhone(newValue: String) {
        setEvent(LoginEvent.ChangePhone(newValue))
    }

    fun updatePassword(newValue: String) {
        setEvent(LoginEvent.ChangePassword(newValue))
    }
}