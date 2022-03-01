package com.example.compose.modules.login.stateexamples.sixth


import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.compose.ui.commons.button.DefaultButton
import com.example.compose.ui.commons.textField.StateTextField
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val email = viewModel.email.collectAsState()
        val password = viewModel.password.observeAsState()
        val updatePassword: (text: String) -> Unit =  { viewModel.updatePassword(it) }
//        val updatePassword: (text: String) -> Unit =  remember{
//            { viewModel.updatePassword(it) }
//        }


        Column {

            Email(email = email.value ){
                viewModel.updateEmail(it)
            }


            Spacer(modifier = Modifier.padding(4.dp))

            Password(password = password.value ?: "",
                onPasswordChanged = {
                    updatePassword(it)
                }
            )

            Spacer(modifier = Modifier.padding(12.dp))
            Button()

        }
    }
}
@Composable
fun Email(
    email: String,
    onEmailChanged: (String) -> Unit,
) {
    Log.d("Test", "Email: ")

    StateTextField(value = email,
        onValueChanged = {
            onEmailChanged(it)
        }, "Email"
    )
}

@Composable
fun Password(
    password: String,
    onPasswordChanged: (String) -> Unit,
) {
    //  Log.d("Test", "Password: ")
   Log.d("Test", "Password: ${password.hashCode()} - ${onPasswordChanged.hashCode()}")

    StateTextField(value = password,
        onValueChanged = {
            onPasswordChanged(it)
        }, "Password"
    )
}

@Composable
fun Button(){
    Log.d("Test", "Button: ")

    DefaultButton("Login") {

    }
}

class LoginViewModel : ViewModel() {


    private val _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

//    private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
//    val isLoading: State<Boolean> get() = _isLoading
//


    fun updatePassword(newValue: String) {
        _password.value = newValue
    }

    fun updateEmail(newValue: String) {
        _email.value = newValue
    }
}