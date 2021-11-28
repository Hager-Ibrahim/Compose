package com.example.compose.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.fragment.app.Fragment
import androidx.compose.ui.platform.ComposeView
import com.example.compose.components.MainScreen.MainScreenFinal
import com.example.compose.components.state.LoginStateFirst
import com.example.compose.components.state.LoginStateSecond
import com.example.compose.components.state.LoginStateThird

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginStateFirst()
                }
            }
        }
    }




}