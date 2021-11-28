package com.example.compose.components.state

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.compose.R
import com.example.compose.components.ui.AuthTextField
import com.example.compose.components.ui.DefaultButton
import com.example.compose.components.ui.ImageFromRes

@Composable
fun LoginStateSecond() {
    Column() {
        val text = mutableStateOf("")
        ImageFromRes(
            R.drawable.login,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F))
        AuthTextField(hint = "Password")

        TextField(
            value = text.value,
            onValueChange = {

                Log.d("TAG", "LoginStateSecond: ${text.value}")
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
                Text("Email")
            }

        )

        DefaultButton(buttonText = "Login") {}
    }
}