package com.example.compose.modules.login.stateexamples.j


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.*
import com.example.compose.R
import com.example.compose.modules.login.stateexamples.i.NormalTextField
import com.example.compose.ui.theme.DarkGrey
import com.example.compose.ui.theme.LightGrey

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    val states by viewModel.uiState.observeAsState()

    val pass = states?.password
    var passwordVisibility by remember { mutableStateOf(false) }
    val email = states?.email


    Column() {
        PasswordTextField(
            text = pass,
            stringResource(id = R.string.phone),
            passwordVisibility, {
                viewModel.updatePassword(it)
            }, {
                passwordVisibility = !passwordVisibility
            })

        NormalTextField(text = email, onValueChanged = {
            viewModel.updateEmail(it)
        })

        Button(
            onClick = { /*TODO*/ },
            enabled = states?.submitButtonEnabled ?: false) {
            Text(text = stringResource(id = R.string.app_name))
        }

    }
}



@Composable
fun PasswordTextField(
    text: String?,
    hint: String? = "",
    isPasswordVisible: Boolean,
    onValueChanged: (String) -> Unit,
    onPasswordIconClicked: () -> Unit

    ) {
    val borderColor = if (text?.isEmpty() == true) Color.Red else Color.Transparent
    val passwordIcon = if(isPasswordVisible) R.drawable.ic_visibility_on else R.drawable.ic_visibility_off
    val visualTransformation =  if(isPasswordVisible)
        PasswordVisualTransformation()
    else VisualTransformation.None



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
        }, trailingIcon = {
            PasswordIcon(icon = passwordIcon){
                onPasswordIconClicked()
            }
        }
        , keyboardOptions = KeyboardOptions(
            keyboardType= KeyboardType.Password,
            imeAction = ImeAction.Done)
    , visualTransformation = visualTransformation)
}

@Composable
fun PasswordIcon(icon: Int, onPasswordIconClicked: () -> Unit){
        Icon(
            painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.clickable {
                onPasswordIconClicked()
            }
        )
}

class LoginViewModel : ViewModel() {

    private val _uiState = MutableLiveData<LoginState>()
    val uiState: LiveData<LoginState>
        get() = _uiState


    fun updateEmail(newValue: String) {

        _uiState.value =LoginEvent.EmailChange.EmailData(newValue).updatePreviousState(
            uiState.value ?: LoginState())
    }

    fun updatePassword(newValue: String) {
        _uiState.value =LoginEvent.PasswordChange.PasswordData(newValue).updatePreviousState(
            uiState.value ?: LoginState())
    }
}

@Preview
@Composable
fun PreviewPasswordEditText(){
    PasswordTextField(text = "","", true, {  },{})
}