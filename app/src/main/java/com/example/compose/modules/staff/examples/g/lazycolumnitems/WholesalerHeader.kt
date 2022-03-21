package com.example.compose.modules.staff.examples.g.lazycolumnitems

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R
import com.example.compose.ui.theme.*

@Preview
@Composable
fun WholesalerHeader(){

    Row(
        Modifier
            .padding(12.dp)
            .wrapContentHeight()
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(TitanWhite)
            .border(1.dp, Flamingo80, RoundedCornerShape(12.dp))
            .padding(horizontal = 12.dp, vertical = 8.dp)) {

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .requiredHeight(30.dp)
                .requiredWidth(30.dp)

        )

        Text(
            text = "Wholesaler name",
            style = TextStyle(
                color = Tangerine,
                fontFamily = FontFamily(Font(R.font.cairo_bold)),
                fontSize = 16.sp
            ),
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .wrapContentHeight()
                .wrapContentWidth()

        )


        Text(
            text = "(5)",
            style = TextStyle(
                color = Dawn,
                fontFamily = FontFamily(Font(R.font.cairo_regular)),
                fontSize = 14.sp
            ),
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .align(CenterVertically)

        )
    }
}