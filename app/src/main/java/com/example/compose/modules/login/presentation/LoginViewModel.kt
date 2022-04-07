package com.example.compose.modules.login.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose.modules.login.presentation.screen.LoginEvent
import com.example.compose.modules.login.presentation.screen.LoginEvent.*
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
                    is ChangePhone ->
                        _state.update { state->
                            state.copy(
                                phone = state.phone.copy(text = it.phone),
                            )}

                    is ChangePassword ->
                        _state.update { state->
                            state.copy(
                                password = state.password.copy(text = it.password),
                            )}

                    ShowPassword ->
                        _state.update { state->
                            state.copy(
                                showPassword = !state.showPassword
                            )}

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
        setEvent(ChangePhone(newValue))
    }

    fun updatePassword(newValue: String) {
        setEvent(ChangePassword(newValue))
    }

    fun updatePasswordVisibility() {
        setEvent(ShowPassword)
    }

    fun login(email: String?, pass: String?){
        setEvent(Login(email, pass))
    }
}