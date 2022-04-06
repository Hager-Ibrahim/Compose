package com.example.compose.ui.commons.textField

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.compose.R
import com.example.compose.ui.theme.DarkGrey
import com.example.compose.ui.theme.LightGrey

@SuppressLint("ModifierParameter")
@Composable
fun BaseTextField(
    text: String?,
    hint: String? = "",
    modifier: Modifier= Modifier,
    leadingIcon: @Composable (() -> Unit)? = {},
    trailingIcon: @Composable () -> Unit = {},
    keyboardOptions: KeyboardOptions,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChanged: (String) -> Unit,
    ) {

    val borderColor = if (text?.isEmpty() == true) Color.Red else Color.Transparent
    val baseLeadingIcon: (@Composable () -> Unit)? = if (leadingIcon != null) {
        { leadingIcon() }
    } else null


    TextField(
        value = text ?:"",
        onValueChange = {
            onValueChanged(it)
        },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(16.dp))
            .border(
                1.dp, borderColor, RoundedCornerShape(16.dp)
            ).then(modifier),
        colors = TextFieldDefaults.textFieldColors(
            textColor = DarkGrey,
            backgroundColor = LightGrey,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ), placeholder = {
            Text(hint ?: "")
        },leadingIcon=  baseLeadingIcon
        , trailingIcon = {
            trailingIcon()
        }
        , keyboardOptions = keyboardOptions
        , visualTransformation = visualTransformation
    )
}

@Composable
fun ErrorIcon(){
    Image(
        painterResource(id = R.drawable.ic_error),
        contentDescription = null,
        modifier = Modifier.clickable {

        }
    )
}