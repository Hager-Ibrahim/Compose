package com.example.compose.modules.login

import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.compose.R

fun Fragment.openLoginFragment(){
        val navController = Navigation.findNavController(requireActivity(), R.id.container)
        navController.navigate(
            R.id.loginFragment
        )
}
