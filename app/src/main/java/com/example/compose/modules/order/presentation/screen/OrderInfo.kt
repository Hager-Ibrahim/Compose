package com.example.compose.modules.order.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.compose.R
import com.example.compose.ui.theme.Martinique


@Composable
fun OrderInfo(){
    ConstraintLayout(modifier = Modifier.wrapContentHeight().fillMaxWidth()) {
        val (image, infoTitle, infoContent,) = createRefs()
        val topGuideline = createGuidelineFromTop(4.dp)
        val bottomGuideline = createGuidelineFromBottom(4.dp)
        val startGuideline = createGuidelineFromStart(12.dp)
        val endGuideline = createGuidelineFromEnd(12.dp)


        Image(
            painter = painterResource(id = R.drawable.ic_in_your_cart),
            contentDescription = "",
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .constrainAs(image) {
                    linkTo(startGuideline, endGuideline, bias = 0F)
                    linkTo(topGuideline, bottomGuideline, bias = 0F)
                },


            )

        Text(
            text = "Order details",
            style = TextStyle(
                color = Martinique,
                fontFamily = FontFamily(Font(R.font.cairo_bold)),
                fontSize = 14.sp
            ),
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .constrainAs(infoTitle) {
                    linkTo(image.top, image.bottom, bias = 0F)
                    linkTo(image.end, endGuideline, startMargin = 12.dp, bias = 0F)
                }
        )

        Text(
            text = "Quantity",
            style = TextStyle(
                color = Martinique,
                fontFamily = FontFamily(Font(R.font.cairo_regular)),
                fontSize = 14.sp
            ),
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .constrainAs(infoContent) {
                    linkTo(infoTitle.top, infoTitle.bottom)
                    linkTo(infoTitle.end, endGuideline, startMargin = 4.dp, bias = 0F)
                }
        )

    }
}