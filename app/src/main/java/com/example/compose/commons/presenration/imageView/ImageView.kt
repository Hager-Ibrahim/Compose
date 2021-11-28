package com.example.compose.commons.presenration.imageView

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.compose.R
@Composable
fun ImageFromRes(imageId: Int, modifier: Modifier) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = "",
        modifier = modifier,
        contentScale = ContentScale.Crop
        )
}