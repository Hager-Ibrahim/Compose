package com.example.compose.ui.commons.textField

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.compose.R
import com.example.compose.ui.theme.DarkGrey
import com.example.compose.ui.theme.LightGrey

@Composable
fun PasswordTextField(
    text: String?,
    hint: String? = "",
    isPasswordVisible: Boolean,
    onValueChanged: (String) -> Unit,
    onPasswordIconClicked: () -> Unit

) {

    val borderColor = if (text?.isEmpty() == true) Color.Red else Color.Transparent
    val passwordIcon =
        if (isPasswordVisible) R.drawable.ic_visibility_on else R.drawable.ic_visibility_off
    val visualTransformation = if (isPasswordVisible)
        PasswordVisualTransformation()
    else VisualTransformation.None



    TextField(
        value = text ?: "",
        onValueChange = {
            onValueChanged(it)
        },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(
                1.dp, borderColor, RoundedCornerShape(16.dp)
            ),
        colors = TextFieldDefaults.textFieldColors(
            textColor = DarkGrey,
            backgroundColor = LightGrey,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ), placeholder = {
            Text(hint ?: "")
        }, trailingIcon = {
            PasswordIcon(icon = passwordIcon) {
                onPasswordIconClicked()
            }
        }, keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ), visualTransformation = visualTransformation
    )
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
