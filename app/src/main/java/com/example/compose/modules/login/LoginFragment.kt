package com.example.compose.modules.login

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.compose.R
import com.example.compose.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {


    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater, null, false)
        binding.compose.setContent {
            Text(
                text = "Compose view",
                fontSize = 20.sp,
                color = Color.Black)
        }
        return binding.root
    }
}