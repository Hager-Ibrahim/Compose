package com.example.compose.components.fragment.staff.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.compose.R
import com.example.compose.commons.presenration.imageView.ImageFromRes
import com.example.compose.commons.presenration.shapes.DefaultShape
import com.example.compose.commons.presenration.text.DefaultText

@Composable
fun FullStaffItem() {
    val constraints = ConstraintSet {
        val image = createRefFor("image")
        val name = createRefFor("name")
        val title = createRefFor("title")
        val state =createRefFor("status")
        val workingHours =createRefFor("working_hours")


        constrain(image) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            bottom.linkTo(parent.bottom)
        }

        constrain(name) {
            top.linkTo(parent.top)
            start.linkTo(image.end)
            bottom.linkTo(title.top)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        }

        constrain(title) {
            top.linkTo(name.bottom)
            start.linkTo(name.start)
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        }

        constrain(state) {
            top.linkTo(name.top)
            end.linkTo(parent.end)
            bottom.linkTo(name.bottom)
        }

        constrain(workingHours) {
            top.linkTo(title.top)
            end.linkTo(parent.end)
            bottom.linkTo(title.bottom)
        }
    }


    ConstraintLayout(
        constraints,
        modifier = Modifier
            .requiredHeight(80.dp)
            .padding(12.dp)
    ) {
        ImageFromRes(
            imageId = R.drawable.ic_launcher_background,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .wrapContentWidth()
                .layoutId("image")

        )

        DefaultText(
            text = "Staff name",
            color = Color(0xFF34495e),
            fontSize = 18.sp,
            Modifier
                .padding(horizontal = 12.dp)
                .layoutId("name")

        )

        DefaultText(
            text = "Android Developer",
            color = Color(0xFF9b9b9b),
            fontSize = 16.sp,
            Modifier
                .padding(horizontal = 12.dp)
                .layoutId("title")

        )

        DefaultShape(CircleShape, 10.dp, Color(0xFF7ed321),"status")
        DefaultText(
            text = "3 h",
            color = Color(0xFF9b9b9b),
            fontSize = 14.sp,
            Modifier
                .layoutId("working_hours")

        )

    }

}