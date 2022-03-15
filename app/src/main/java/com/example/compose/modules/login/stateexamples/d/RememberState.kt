package com.example.compose.modules.login.stateexamples.d

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.compose.ui.commons.textField.CustomTextField


@Composable
fun LoginScreen() {
    Column(Modifier.background(Color.White)) {
        val text = remember { mutableStateOf("")}
        Log.d("TEST", "LoginScreen: ${text.value}")

        CustomTextField(value = text.value,
            onValueChanged = {
                text.value = it
                Log.d("TEST", "onValueChanged: ${text.value}")
            })
    }
}