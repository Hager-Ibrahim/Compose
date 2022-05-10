package com.example.compose.modules.login.alignment


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R

/**
 * Arrangement.SpaceBetween:
 * places first item in the main axis start and the last item
 * in the main axis end, then distribute the remaining items
 * evenly in the space left.
 */
@Preview
@Composable
fun SpaceBetweenFirstExample() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(BorderStroke(1.dp, color = Color.Gray))
            .padding(16.dp)
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = CenterVertically
    ) {
        Text(
            text = "Logout",
            fontSize = 18.sp,
            color = Color.White
        )
        Image(
            painter = painterResource(R.drawable.ic_logout),
            contentDescription = "",
            modifier = Modifier.wrapContentSize(),
            contentScale = ContentScale.Crop
        )

    }
}