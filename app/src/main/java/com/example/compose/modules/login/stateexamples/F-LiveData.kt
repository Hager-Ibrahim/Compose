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

@Preview
@Composable
fun LiveDataExampleScreenPreview() {
    val viewModel = LiveDataExampleViewModel()
    LiveDataExampleScreen(viewModel)
}

@Composable
fun LiveDataExampleScreen(
    viewModel: LiveDataExampleViewModel
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {

        val email = viewModel.email.observeAsState()

        Column {


            CustomTextField(
                value = email.value ?:"",
                onValueChanged = {
                    viewModel.updateEmail(it)
                }, "Email"
            )
        }
    }
}

class LiveDataExampleViewModel : ViewModel() {


    private val _email = MutableLiveData<String>()
    val email: LiveData<String>
        get() = _email

    fun updateEmail(newValue: String) {
        _email.value = newValue
    }
}