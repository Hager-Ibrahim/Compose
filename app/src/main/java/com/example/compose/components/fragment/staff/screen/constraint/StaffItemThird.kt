package com.example.compose.components.fragment.staff.screen.constraint

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.compose.R
import com.example.compose.commons.presenration.imageView.ImageFromRes

@Composable
fun StaffItemThird() {
    val constraints = ConstraintSet{
        val image= createRefFor("image")
        val name =createRefFor("name")
        val title =createRefFor("title")

        constrain(image){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            bottom.linkTo(parent.bottom)
        }

        constrain(name){
            top.linkTo(parent.top)
            start.linkTo(image.end)
            bottom.linkTo(title.top)
        }

        constrain(title){
            top.linkTo(name.bottom)
            start.linkTo(name.start)
            bottom.linkTo(parent.bottom)
        }


    }


    ConstraintLayout() {
        ImageFromRes(
            imageId = R.drawable.ic_launcher_background,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)

        )
    }

}

// TODO: constraints - layout id