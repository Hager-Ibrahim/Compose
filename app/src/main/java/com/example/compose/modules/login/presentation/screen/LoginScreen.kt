package com.example.compose.modules.login.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.compose.R
import com.example.compose.modules.login.presentation.LoginViewModel
import com.example.compose.ui.commons.button.GradientButton
import com.example.compose.ui.commons.textField.NormalTextField
import com.example.compose.ui.commons.textField.PasswordTextField
import com.example.compose.ui.theme.*

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    val loginState by viewModel.state.collectAsState(LoginState())

    LoginContent(
        password = loginState.password,
        phone = loginState.phone,
        passwordVisibility = loginState.showPassword,
        onPhoneChanged = viewModel::updatePhone,
        onPasswordChanged = viewModel::updatePassword,
        updatePasswordVisibility = viewModel::updatePasswordVisibility,
        onLoginClicked = viewModel::login
    )

}

@Composable
private fun LoginContent(
    password: BaseTextFieldState,
    phone: BaseTextFieldState,
    passwordVisibility: Boolean,
    onPhoneChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    updatePasswordVisibility: () -> Unit,
    onLoginClicked: (String?, String?)-> Unit
) {

    Box(modifier = Modifier.fillMaxWidth()) {

        // region Background
        Image(
            painterResource(id = R.drawable.login_background),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        // endregion

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // region Guidelines
            val startGuideline = createGuidelineFromStart(16.dp)
            val endGuideline = createGuidelineFromEnd(16.dp)
            // endregion

            // region rRef
            val (
                logo,
                signInText,
                welcomeText,
                loginCard) = createRefs()
            //endregion

            // region Logo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Kuzlo logo",
                modifier = Modifier
                    .wrapContentSize()
                    .constrainAs(logo) {
                        linkTo(startGuideline, endGuideline)
                        top.linkTo(parent.top, margin = 80.dp)
                    })
            //endregion

            // region Login text
            Text(
                text = stringResource(id = R.string.login),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.cairo_bold)),
                    color = PrussianBlue
                ),
                modifier = Modifier
                    .constrainAs(signInText) {
                        start.linkTo(startGuideline, margin = 28.dp)
                        top.linkTo(logo.bottom, margin = 50.dp)
                    })
            //endregion

            // region Welcome text
            Text(
                text = stringResource(id = R.string.welcome_back_again),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.cairo_regular)),
                    color = Manatee
                ),
                modifier = Modifier
                    .constrainAs(welcomeText) {
                        start.linkTo(signInText.start)
                        top.linkTo(signInText.bottom)
                    })
            //endregion

            // region Login card
            LoginCard(
                password = password,
                phone = phone,
                passwordVisibility = passwordVisibility,
                onPhoneChanged = onPhoneChanged,
                onPasswordChanged = onPasswordChanged,
                updatePasswordVisibility = updatePasswordVisibility,
                onLoginClicked = onLoginClicked,
                modifier = Modifier.constrainAs(loginCard) {
                    linkTo(startGuideline, endGuideline)
                    top.linkTo(welcomeText.bottom)
                }
            )
            // endregion

        }
    }
}

@Composable
fun LoginCard(
    modifier: Modifier = Modifier,
    password: BaseTextFieldState,
    phone: BaseTextFieldState,
    passwordVisibility: Boolean,
    onPhoneChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    updatePasswordVisibility: () -> Unit,
    onLoginClicked: (String?, String?)-> Unit
) {

    Column(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .then(modifier)
    ) {

        // region Phone text field
        NormalTextField(
            text = phone.text,
            hint = stringResource(id = R.string.phone),
            onValueChanged = { onPhoneChanged(it) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Next
            )
        )
        // endregion

        Spacer(modifier = Modifier.padding(8.dp))

        //region Password text field
        PasswordTextField(
            text = password.text,
            hint = stringResource(id = R.string.password),
            isPasswordVisible = passwordVisibility,
            onValueChanged = {
                onPasswordChanged(it)
            },
            onPasswordIconClicked = {
                updatePasswordVisibility()
            }, keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )
        //endregion

        Spacer(modifier = Modifier.padding(4.dp))

        //region Forgot password button
        Button(
            onClick = { /* Do something! */ },
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.Transparent
            ), modifier = Modifier.align(Alignment.Start),
            elevation = null,
        ) {
            Text(
                stringResource(id = R.string.forgot_password_question),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.cairo_regular)),
                    color = OutrageousOrange
                )
            )
        }
        //endregion

        Spacer(modifier = Modifier.padding(16.dp))

        //region Submit Button
        GradientButton(
            gradient = buttonGradient(),
            isEnabled = listOf(phone, password).all { it.isValid(LocalContext.current) },
            onClick = { onLoginClicked(phone.text, password.text) },
        ) {
            Text(
                stringResource(id = R.string.login),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.cairo_bold)),
                    color = Color.White
                )
            )
        }
        //endregion
    }

}

@Composable
private fun buttonGradient() = Brush.verticalGradient(
    colors = listOf(
        FuelYellow,
        California,
    )
)