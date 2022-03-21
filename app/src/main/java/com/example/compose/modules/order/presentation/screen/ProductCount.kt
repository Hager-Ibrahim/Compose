package com.example.compose.modules.order.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.compose.R
import com.example.compose.modules.order.presentation.model.OrderDetailsUIModel
import com.example.compose.ui.theme.PrussianBlue

@Composable
fun ProductCount(order: OrderDetailsUIModel) {
    ConstraintLayout(modifier = Modifier
        .wrapContentHeight()
        .fillMaxWidth()) {
        val (image, title, quantity,) = createRefs()
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
                    linkTo(topGuideline, bottomGuideline)
                },


        )

        Text(
            text = "Order details",
            style = TextStyle(
                color = PrussianBlue,
                fontFamily = FontFamily(Font(R.font.cairo_bold)),
                fontSize = 18.sp
            ),
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .constrainAs(title) {
                    linkTo(topGuideline, quantity.top)
                    linkTo(image.end, endGuideline, startMargin = 12.dp, bias = 0F)
                }
        )

        Text(
            text = stringResource(id = R.string.products_amount, order.numberOfProducts),
            style = TextStyle(
                color = PrussianBlue,
                fontFamily = FontFamily(Font(R.font.cairo_regular)),
                fontSize = 18.sp
            ),
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .constrainAs(quantity) {
                    linkTo(title.bottom, bottomGuideline)
                    linkTo(title.start, endGuideline, bias = 0F)
                }
        )

    }
}