package com.example.compose.modules.login.stateexamples.forth

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import com.example.compose.ui.commons.textField.StateTextField

@Composable
fun LoginScreen() {
    Column() {
        var text by remember { mutableStateOf("") }
        LoginContent(text){
            text = it
        }

    }
}

@Composable
fun LoginContent(text: String, onTextChange: (String) -> Unit) {
    Column() {

        StateTextField(value = text,
            onValueChanged = {
                onTextChange(it)
            })
    }
}