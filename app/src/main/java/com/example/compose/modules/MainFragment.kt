package com.example.compose.modules

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Surface
import androidx.compose.ui.graphics.Color
import androidx.fragment.app.Fragment
import androidx.compose.ui.platform.ComposeView
import com.example.compose.modules.examples.TextExample

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Surface(color = Color.White) {
                 //   TextExample()
                }
            }
        }
    }

}