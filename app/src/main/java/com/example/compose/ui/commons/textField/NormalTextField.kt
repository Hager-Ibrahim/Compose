package com.example.compose.ui.commons.textField

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.compose.R

@SuppressLint("ModifierParameter")
@Composable
fun NormalTextField(
             text: String?,
             hint: String? = "",
             keyboardOptions: KeyboardOptions,
             modifier: Modifier= Modifier,
             onValueChanged: (String) -> Unit, ){
    val isErrorIconVisible = text?.isEmpty() == true

    BaseTextField(
        text = text,
        hint = hint,
        leadingIcon = {
            CountryCode()
        },
        trailingIcon = {
            if(isErrorIconVisible) ErrorIcon()
        },
        keyboardOptions = keyboardOptions,
        modifier = modifier,
    ) {
        onValueChanged(it)
    }
}

@Composable
fun CountryCode(){
        Image(
            modifier =
            Modifier.padding(horizontal = 6.dp),
            painter = painterResource(id = R.drawable.eg),
            contentDescription = "",
        )
}
