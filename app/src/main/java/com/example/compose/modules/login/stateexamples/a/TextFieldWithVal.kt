package com.example.compose.modules.login.stateexamples.a

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
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
