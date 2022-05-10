package com.example.compose.modules.staff.examples

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.compose.R
import com.example.compose.ui.commons.imageView.ImageFromRes
import com.example.compose.ui.commons.text.DefaultText

@Preview(showBackground = true)
@Composable
fun CompleteExample() {
    val constraints = ConstraintSet {
        val image = createRefFor("image")
        val name = createRefFor("name")
        val title = createRefFor("title")


        constrain(image) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
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
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        }

    }


    ConstraintLayout(
        constraints,
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
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
            text = "name",
            color = Color(0xFF34495e),
            fontSize = 18.sp,
            Modifier
                .padding(horizontal = 12.dp)
               // .background(Color.Red)
                .layoutId("name")

        )

        DefaultText(
            text = "Android developer",
            color = Color(0xFF9b9b9b),
            fontSize = 16.sp,
            Modifier
                .padding(horizontal = 12.dp)
                .layoutId("title")

        )


    }

}