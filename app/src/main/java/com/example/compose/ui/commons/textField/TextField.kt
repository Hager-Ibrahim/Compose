package com.example.compose.ui.commons.textField

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text


@Composable
fun AuthTextField(
    hint: String,
    text: String,
    onTextChanged: (String)-> Unit) {
    DefaultTextField(hint = hint, modifier = Modifier
        .fillMaxWidth()
        .padding(start = 24.dp, end = 24.dp, bottom = 4.dp)
        .requiredHeight(52.dp),
    text, onTextChanged)
}

@Composable
fun DefaultTextField(
    hint: String,
    modifier: Modifier,
    text: String,
    onTextChanged: (String)-> Unit
) {
    TextField(
        value = text,
        onValueChange = {
            onTextChanged(it)
        },
        modifier =modifier,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF354b60),
            backgroundColor = Color(0xFFe1e5e9),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ), placeholder = {
            Text(hint)
        }

    )
}
@Composable
fun StateTextField(value: String, onValueChanged: (String)-> Unit, text: String?="Password"){
    TextField(
        value = value,
        onValueChange = {
            onValueChanged(it)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, bottom = 4.dp)
            .requiredHeight(52.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF354b60),
            backgroundColor = Color(0xFFe1e5e9),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ), placeholder = {
            Text(text?:"")
        }
    )
}