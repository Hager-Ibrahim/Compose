package com.example.compose.modules.staff

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.compose.R

fun Fragment.openStaff(){
    val navController = Navigation.findNavController(requireActivity(), R.id.container)
    val args = Bundle()
    navController.navigate(
        R.id.staffFragment, args
    )
}