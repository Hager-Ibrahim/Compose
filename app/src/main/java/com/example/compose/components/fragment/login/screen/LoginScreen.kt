package com.example.compose.components.fragment.login.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.compose.R
import com.example.compose.ui.common.button.DefaultButton
import com.example.compose.ui.theme.presenration.imageView.ImageFromRes
import com.example.compose.ui.theme.presenration.textField.AuthTextField
import com.example.compose.components.fragment.login.LoginViewModel
import com.example.compose.ui.navigation.Screens

//@Composable
//fun LoginScreen(
//    loginViewModel: LoginViewModel,
//    navController: NavController
//) {
//    val email = loginViewModel.email.collectAsState()
//    val password = loginViewModel.password.observeAsState()
//
//    Column(modifier = Modifier.background(Color.White)) {
//        ImageFromRes(
//            R.drawable.login,
//            modifier = Modifier
//                .fillMaxWidth()
//                .weight(1F)
//        )
//        AuthTextField(
//            hint = "Email",
//            email.value
//        ) {
//            loginViewModel.updateEmail(it)
//        }
//        AuthTextField(
//            hint = "Password",
//            password.value ?: ""
//        ) {
//            loginViewModel.updatePassword(it)
//        }
//        DefaultButton(buttonText = "Login") {
//            navController.navigate(route =  "${Screens.StaffScreen.route}/${email.value}")
//        }
//    }
//}


@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    navController: NavController
) {
    val email = loginViewModel.email.collectAsState()
    val password = loginViewModel.password.observeAsState()

    Column(modifier = Modifier.background(Color.White)) {
        ImageFromRes(
            R.drawable.login,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
        )
        AuthTextField(
            hint = "Email",
            email.value
        ) {
            loginViewModel.updateEmail(it)
        }
        AuthTextField(
            hint = "Password",
            password.value ?: ""
        ) {
            loginViewModel.updatePassword(it)
        }
        DefaultButton(buttonText = "Login") {
            navController.navigate(
                route =  Screens.StaffScreen.passData(email.value, password.value?:""))
        }
    }
}