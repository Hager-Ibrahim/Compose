package com.example.compose.modules.login.stateexamples.test

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.compose.ui.commons.textField.StateTextField
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@Composable
fun TimerScreen1(
    viewModel: LoginViewModel
) {
    Surface(color = MaterialTheme.colors.background) {

        var timerDuration by remember {
            mutableStateOf(1000L) // default value = 1 sec
        }

        val test = { timerDuration -= 1000 }
        var email by remember {
            mutableStateOf("") // default value = 1 sec
        }

//        var password by remember {
//            mutableStateOf("") // default value = 1 sec
//        }

        var password = remember {viewModel.password}
        Log.d("TAG", "TimerScreen1: Maain ${test.hashCode()} - ")

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            IncButton { test() }
            Text(timerDuration.toString())
            Email(email = email,
                onEmailChanged = {
                   email = it
                }
            )
//
//            Password(password = password,
//                onPasswordChanged = {
//                   password = it
//                }
//            )

            Password(password = password,
                onPasswordChanged = {
                    viewModel.updatePassword(it)
                }
            )

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
fun IncButton(onClick: ()-> Unit){
    Log.d("TAG", "IncButton: ----")
    Button({
        onClick()
    }) {
        Text("-1 second")
    }
}

class LoginViewModel : ViewModel() {


//    private val _password = MutableLiveData<String>()
//    val password: LiveData<String>
//        get() = _password

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

//    private val _password: MutableState<String> = mutableStateOf("")
//    val password: State<String> get() = _password

    var password by mutableStateOf<String>("")

//


    fun updatePassword(newValue: String) {
        password = newValue
    }

    fun updateEmail(newValue: String) {
        _email.value = newValue
    }
}

@Composable
fun IncButton2(onClick: ()-> Unit){
    Log.d("TAG", "IncButton: ++++")
    Button({
        onClick()
    }) {
        Text("+1 second")
    }
}
@Composable
fun Timer(timerDuration: Long) {
    LaunchedEffect(key1 = timerDuration, block = {
        try {
            startTimer(timerDuration) {
                println("Timer ended")
            }
        } catch (ex: Exception) {
            println("timer cancelled")
        }
    })
}

suspend fun startTimer(time: Long, onTimerEnd: () -> Unit) {
    delay(timeMillis = time)
    onTimerEnd()
}