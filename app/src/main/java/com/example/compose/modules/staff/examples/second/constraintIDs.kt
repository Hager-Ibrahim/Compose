package com.example.compose.modules.staff.examples.second

import androidx.compose.runtime.Composable
import androidx.constraintlayout.compose.ConstraintSet

@Composable
fun StaffItem() {

    val constraints = ConstraintSet {
        val image = createRefFor("image")
        val name = createRefFor("name")
        val title = createRefFor("title")

        constrain(image) {

        }
    }
}