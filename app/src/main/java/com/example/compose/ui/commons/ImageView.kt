package com.example.compose.ui.commons

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.compose.R

@Composable
fun ImageFromRes(modifier: Modifier) {
    Image(
        painter = painterResource(R.drawable.login),
        contentDescription = "",
        modifier = modifier,
        contentScale = ContentScale.Crop
        )
}