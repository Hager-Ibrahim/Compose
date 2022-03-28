package com.example.compose.modules.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.compose.ui.navigation.b.SetupNavGraph
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme() {
                val navController = rememberNavController()
                SetupNavGraph(navController)
               // SetupMainNavGraph(navController)
            }
        }
    }


}