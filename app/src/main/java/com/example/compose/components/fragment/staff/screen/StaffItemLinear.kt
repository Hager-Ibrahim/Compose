package com.example.compose.components.fragment.staff.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R
import com.example.compose.commons.presenration.imageView.ImageFromRes
import com.example.compose.commons.presenration.shapes.DefaultShape
import com.example.compose.commons.presenration.text.DefaultText



@Composable
fun StaffItem() {

    Row(
        modifier =
        Modifier
            .requiredHeight(80.dp)
            .padding(all = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        ImageFromRes(
            R.drawable.ic_launcher_background,
            Modifier
                .size(50.dp)
                .clip(CircleShape)
        )

        StaffNameTitleColumn(Modifier.padding(horizontal = 12.dp))

        StaffStatusWorkingHoursColumn(
            Modifier
                .fillMaxHeight()
                .padding(vertical = 12.dp)
        )
    }

}

@Composable
fun StaffNameTitleColumn(modifier: Modifier) {
    Column(modifier = modifier) {
        DefaultText(
            text = "Ahmed Ehab",
            color = Color(0xFF34495e),
            fontSize = 18.sp
        )

        DefaultText(
            text = "Android Developer",
            color = Color(0xFF9b9b9b),
            fontSize = 16.sp
        )
    }
}

@Composable
fun StaffStatusWorkingHoursColumn(modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        DefaultShape(CircleShape, 10.dp, Color(0xFF7ed321))
        DefaultText(
            text = "3 h",
            color = Color(0xFF9b9b9b),
            fontSize = 14.sp
        )
    }
}

