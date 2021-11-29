package com.example.compose.components.fragment.staff.screen.constraint

import androidx.compose.runtime.Composable
import androidx.constraintlayout.compose.ConstraintSet

@Composable
fun StaffItemSecond() {
    val constraints = ConstraintSet{
        val image= createRefFor("image")
        val name =createRefFor("name")
        val title =createRefFor("title")

        constrain(image){

        }

    }

}