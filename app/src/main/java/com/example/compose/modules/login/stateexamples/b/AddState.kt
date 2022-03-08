package com.example.compose.modules.login.stateexamples.b

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import com.example.compose.ui.commons.textField.StateTextField


@Composable
fun LoginScreen() {
    Column() {
        val text = mutableStateOf("")
        StateTextField( value = text.value,
            onValueChanged = {
                text.value = it
                Log.d("TAG", "LoginStateSecond: ${text.value}")
            })
    }
}