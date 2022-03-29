package com.example.compose.modules.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Surface
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.ViewModelProvider
import com.example.compose.modules.login.stateexamples.j.LoginScreen
import com.example.compose.modules.login.stateexamples.j.LoginViewModel


class LoginFragment : Fragment() {

    private lateinit var viewModel : LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        return ComposeView(requireContext()).apply {
            setContent {
               Surface() {
                    //LoginScreen()
                   LoginScreen(viewModel = viewModel)
               }

            }
        }
    }
}