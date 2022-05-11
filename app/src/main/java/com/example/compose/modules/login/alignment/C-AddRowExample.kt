package com.example.compose.modules.login.alignment

import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun AddRowExample() {

    Column() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(200.dp)
                .border(BorderStroke(1.dp, color = Color.Gray))
        ) {
            Text(
                text = "Test",
                fontSize = 18.sp,
                color = Color.Blue,
                modifier = Modifier.align(Alignment.CenterHorizontally)

            )
        }
        Spacer(modifier = Modifier.padding(20.dp))
        Row(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .border(BorderStroke(1.dp, color = Color.Gray))
        ) {
            Text(
                text = "Test",
                fontSize = 18.sp,
                color = Color.Blue,
                modifier = Modifier.align(Alignment.CenterVertically)

            )
        }
    }

}