package com.example.compose.ui.commons

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun ImageFromRes(imageId: Int, modifier: Modifier) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = "",
        modifier = modifier,
        )
}