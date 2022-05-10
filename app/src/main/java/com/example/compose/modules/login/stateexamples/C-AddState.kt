package com.example.compose.modules.login.stateexamples

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.ui.commons.textField.CustomTextField


@Preview
@Composable
fun LoginScreen() {
    Column(Modifier.background(Color.White).fillMaxHeight()) {
        val text = mutableStateOf("")
        Log.d("TEST STATE", "LoginScreen: ${text.value}")

        CustomTextField( value = text.value,
            onValueChanged = {
                text.value = it
                Log.d("TEST STATE", "onValueChanged: ${text.value}")
            })
    }
}