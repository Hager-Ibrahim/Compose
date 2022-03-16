package com.example.compose.modules.login.stateexamples.i

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose.ui.commons.button.DefaultButton
import com.example.compose.ui.commons.modifiers.visible
import com.example.compose.ui.commons.textField.CustomTextField
import com.example.compose.ui.commons.livedata.Event
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(viewModel: LoginViewModel, onButtonClicked: () -> Unit) {

    val text = viewModel.name.observeAsState()

    val isLoading: Boolean by viewModel.isLoading
    val navigate = viewModel.navigate.observeAsState().value

    LaunchedEffect(navigate) {
        Log.d("TEST", "LaunchedEffect: navigate $navigate")
        navigate?.getContentIfNotHandled()?.let {
            onButtonClicked()
        }
    }

//    LaunchedEffect(isLoading) {
//        Log.d("TEST", "LaunchedEffect: isloading $isLoading")
//    }

    LoginContent(
        text = text.value ?:"",
        isLoading = isLoading,
        onTextChange = {
            viewModel.updateName(it)
        }) {
        viewModel.fakeNetworkCall()
    }
}

@Composable
fun LoginContent(
    text: String,
    isLoading: Boolean,
    onTextChange: (String) -> Unit,
    onButtonClicked: () -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column() {

            CustomTextField(value = text,
                onValueChanged = {
                    onTextChange(it)
                },"Email")


            Spacer(modifier = Modifier.padding(12.dp))
            DefaultButton("Login") {
                onButtonClicked()
            }
            Spacer(modifier = Modifier.padding(12.dp))

            CircularProgressIndicator(
                Modifier
                    .visible(isLoading)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

class LoginViewModel : ViewModel() {
    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name

    private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: State<Boolean> get() = _isLoading

    private val _navigate = MutableLiveData<Event<Unit>>()
    val navigate: LiveData<Event<Unit>>
        get() = _navigate


    fun updateName(newValue: String) {
        _name.value = newValue
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