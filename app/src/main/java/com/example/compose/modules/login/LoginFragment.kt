package com.example.compose.modules.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.ViewModelProvider
import com.example.compose.modules.login.stateexamples.seventh.LoginScreen
import com.example.compose.modules.login.stateexamples.seventh.LoginViewModel


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
                LoginScreen(viewModel)
            }
        }
    }
}