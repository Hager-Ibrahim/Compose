package com.example.compose.components.MainScreen

import androidx.compose.runtime.Composable
import com.example.compose.components.ui.AuthTextField
import com.example.compose.components.ui.DefaultButton
import com.example.compose.components.ui.DefaultTextField

@Composable
    fun MainScreenFirst() {
        AuthTextField(hint = "")
        DefaultButton(buttonText = "Login") {}
    }