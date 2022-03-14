package com.example.compose.modules.login.stateexamples.aa

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.compose.ui.commons.textField.CustomTextField

//Recompostion

@Composable
fun LoginScreen() {
    Column(Modifier.background(Color.White).fillMaxHeight()) {
        var text = ""

        CustomTextField( value = text,
            onValueChanged = {
                text += it
                Log.d("TEST", "onValueChanged: $text")
            })
    }

}