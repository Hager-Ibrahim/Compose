package com.example.compose.ui.commons.textField


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.compose.R


@Composable
fun PasswordTextField(
    text: String?,
    hint: String? = "",
    isPasswordVisible: Boolean,
    keyboardOptions: KeyboardOptions,
    onValueChanged: (String) -> Unit,
    onPasswordIconClicked: () -> Unit
){
    val passwordIcon =
        if (isPasswordVisible) R.drawable.ic_visibility_on else R.drawable.ic_visibility_off
    val isErrorIconVisible = text?.isEmpty() == true

    BaseTextField(
        text = text,
        hint = hint,
        trailingIcon = {
            PasswordIconAndErrorIcon(
                icon = passwordIcon,
                isErrorIconVisible = isErrorIconVisible
            ) {
                onPasswordIconClicked()
            }
        },
        leadingIcon = null,
        keyboardOptions = keyboardOptions
    ) {
        onValueChanged(it)
    }
}

@Composable
fun PasswordIconAndErrorIcon(
    icon: Int,
    isErrorIconVisible: Boolean,
    onPasswordIconClicked: () -> Unit,
    ) {
    Row (modifier = Modifier.padding(horizontal = 8.dp)) {
        if(isErrorIconVisible) ErrorIcon()

        Spacer(Modifier.padding(4.dp))

        PasswordIcon(
            icon = icon,
            onPasswordIconClicked = onPasswordIconClicked)
    }
}

@Composable
fun PasswordIcon(icon: Int, onPasswordIconClicked: () -> Unit) {
    Icon(
        painterResource(id = icon),
        contentDescription = null,
        modifier = Modifier.clickable {
            onPasswordIconClicked()
        }
    )
}
