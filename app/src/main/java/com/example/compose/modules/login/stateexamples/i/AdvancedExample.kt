package com.example.compose.modules.login.stateexamples.i

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.compose.R
import com.example.compose.ui.theme.DarkGrey
import com.example.compose.ui.theme.LightGrey

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    val text = viewModel.email.observeAsState()

    NormalTextField(
        text = text.value ,
        stringResource(id = R.string.phone)
    ) {
        viewModel.updateEmail(it)
    }

}

@Composable
fun NormalTextField(
    text: String?,
    hint: String? = "",
    onValueChanged: (String) -> Unit,

    ) {
    val modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(16.dp)
        .clip(RoundedCornerShape(16.dp))
        .border(
            BorderStroke(1.dp, if (text?.isEmpty() == true) Color.Red else Color.Transparent),
            RoundedCornerShape(16.dp)
        )


    TextField(
        value = text ?:"",
        onValueChange = {
            onValueChanged(it)
        },
        modifier = modifier,
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
            ErrorIcon(text)
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
fun ErrorIcon(text: String?){
    if (text?.isEmpty() == true ) {
            Image(
                painterResource(id = R.drawable.ic_error),
                contentDescription = null,
                modifier = Modifier.clickable {

                }
        )

    }
}
class LoginViewModel : ViewModel() {


    private val _email = MutableLiveData<String>()
    val email: LiveData<String>
        get() = _email

    fun updateEmail(newValue: String) {
        _email.value = newValue
    }
}

@Preview
@Composable
fun PreviewNormalEditText(){
    NormalTextField(text = "", onValueChanged = {})
}