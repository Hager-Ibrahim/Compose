package com.example.compose.components.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.compose.ui.navigation.*
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme() {
                val navController = rememberNavController()
                SetupMainNavGraphFifth(navController)
            }
        }
    }


}