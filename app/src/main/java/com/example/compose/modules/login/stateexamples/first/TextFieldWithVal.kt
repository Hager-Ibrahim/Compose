package com.example.compose.modules.login.stateexamples.first

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import com.example.compose.ui.commons.textField.StateTextField


@Composable
fun LoginScreen() {
    Column() {
        var text = ""
        StateTextField( value = text,
            onValueChanged = {
                text = it
                Log.d("TAG", "LoginStateFirst: $text")
            })
    }

}
