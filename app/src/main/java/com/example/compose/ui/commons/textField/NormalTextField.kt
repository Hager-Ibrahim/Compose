package com.example.compose.ui.commons.textField

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.compose.R
import com.example.compose.ui.theme.DarkGrey
import com.example.compose.ui.theme.LightGrey


@Composable
fun NormalTextField(
    text: String?,
    hint: String? = "",
    onValueChanged: (String) -> Unit,

    ) {
    val borderColor = if (text?.isEmpty() == true) Color.Red else Color.Transparent
    val isErrorIconVisible = text?.isEmpty() == true

    TextField(
        value = text ?:"",
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
        },leadingIcon={
            CountryCode()
        }, trailingIcon = {
            if(isErrorIconVisible) ErrorIcon()
        }
        , keyboardOptions = KeyboardOptions(
            keyboardType= KeyboardType.Text,
            imeAction = ImeAction.Done)
    )
}

@Composable
fun CountryCode(){
    Row(  modifier =
    Modifier
        .padding(horizontal = 16.dp,)
        .clip(RoundedCornerShape(16.dp))
        .background(Color.White)
        .padding(horizontal = 4.dp, vertical = 8.dp)
    ) {
        Text(
            text = "+20",
            modifier = Modifier.align(
                Alignment.CenterVertically))
        Image(
            modifier =
            Modifier.padding(horizontal = 6.dp),
            painter = painterResource(id = R.drawable.eg),
            contentDescription = "",
        )
    }
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