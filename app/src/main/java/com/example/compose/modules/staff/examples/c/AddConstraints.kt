package com.example.compose.modules.staff.examples.c


import androidx.compose.runtime.Composable
import androidx.constraintlayout.compose.ConstraintSet
import kotlinx.coroutines.NonDisposableHandle.parent


@Composable
fun StaffItem() {
    val constraints = ConstraintSet {
        val image = createRefFor("image")
        val name = createRefFor("name")
        val title = createRefFor("title")


        constrain(image) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            bottom.linkTo(parent.bottom)
        }

        constrain(name) {
            top.linkTo(parent.top)
            bottom.linkTo(title.top)
            start.linkTo(image.end)
        }

        constrain(title) {
            top.linkTo(name.bottom)
            bottom.linkTo(parent.bottom)
            start.linkTo(name.start)

        }

    }



}