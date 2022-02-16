package com.example.compose.modules.staff.examples.fifth


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.compose.R
import com.example.compose.ui.commons.imageView.ImageFromRes
import com.example.compose.ui.commons.text.DefaultText

@Preview(showBackground = true)
@Composable
fun StaffItem() {

    ConstraintLayout(
        modifier = Modifier
            .requiredHeight(80.dp)
            .padding(12.dp)
    ) {

        val (image, name, title) = createRefs()

        ImageFromRes(
            imageId = R.drawable.ic_launcher_background,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .wrapContentWidth()
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                }

        )

        DefaultText(
            text = "Staff name",
            color = Color(0xFF34495e),
            fontSize = 18.sp,
            Modifier
                .padding(horizontal = 12.dp)
                .constrainAs(name) {
                    top.linkTo(parent.top)
                    start.linkTo(image.end)
                    bottom.linkTo(title.top)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }

        )

        DefaultText(
            text = "Android Developer",
            color = Color(0xFF9b9b9b),
            fontSize = 16.sp,
            Modifier
                .padding(horizontal = 12.dp)
                .constrainAs(title){
                    start.linkTo(name.start)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    top.linkTo(name.bottom)
                    width = Dimension.fillToConstraints
                }

        )

    }

}