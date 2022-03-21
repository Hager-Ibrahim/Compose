package com.example.compose.modules.order.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.compose.R
import com.example.compose.ui.theme.Dawn
import com.example.compose.ui.theme.Martinique
import com.example.compose.ui.theme.Orange
import com.example.compose.ui.theme.TitanWhite


@Preview
@Composable
fun OrderItem() {
    ConstraintLayout(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(16.dp))
            .background(TitanWhite)
    ) {

        val (image, name, quantity, totalPrice, line, unitPriceTitle, unitPrice) = createRefs()
        val topGuideline = createGuidelineFromTop(4.dp)
        val bottomGuideline = createGuidelineFromBottom(4.dp)
        val startGuideline = createGuidelineFromStart(12.dp)
        val endGuideline = createGuidelineFromEnd(12.dp)

        val middleGuideline = createGuidelineFromStart(0.54F)


        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .requiredHeight(46.dp)
                .requiredWidth(46.dp)
                .border(0.5.dp, Color.Black, RoundedCornerShape(12.dp))
                .constrainAs(image) {
                    linkTo(startGuideline, endGuideline, bias = 0F)
                    linkTo(topGuideline, bottomGuideline)
                },
        )

        Text(
            text = "Product name",
            style = TextStyle(
                color = Martinique,
                fontFamily = FontFamily(Font(R.font.cairo_bold)),
                fontSize = 14.sp
            ),
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .constrainAs(name) {
                    linkTo(topGuideline, quantity.top)
                    linkTo(image.end, endGuideline, startMargin = 8.dp, bias = 0F)
                }
        )

        Text(
            text = "Quantity",
            style = TextStyle(
                color = Dawn,
                fontFamily = FontFamily(Font(R.font.cairo_regular)),
                fontSize = 14.sp
            ),
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .constrainAs(quantity) {
                    linkTo(name.bottom, totalPrice.top)
                    linkTo(name.start, endGuideline, bias = 0F)
                }
        )

        Text(
            text = "20.LE",
            style = TextStyle(
                color = Orange,
                fontFamily = FontFamily(Font(R.font.cairo_regular)),
                fontSize = 18.sp
            ),
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .constrainAs(totalPrice) {
                    linkTo(quantity.bottom, bottomGuideline,bias = 0F)
                    linkTo(name.start, endGuideline, bias = 0F)
                }
        )

        Divider(
            color = Dawn, thickness = 1.dp,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .width(1.dp)
                .constrainAs(line) {
                    linkTo(quantity.top, totalPrice.bottom,bias = 0F)
                    linkTo(middleGuideline, endGuideline, bias = 0F)
                    height = Dimension.fillToConstraints
                }
        )

        Text(
            text = "Unit Price",
            style = TextStyle(
                color = Dawn,
                fontFamily = FontFamily(Font(R.font.cairo_regular)),
                fontSize = 14.sp
            ),
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .constrainAs(unitPriceTitle) {
                    linkTo(quantity.top, quantity.bottom)
                    linkTo(middleGuideline, endGuideline, startMargin = 16.dp, bias = 0F)
                }
        )

        Text(
            text = "20.LE",
            style = TextStyle(
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.cairo_regular)),
                fontSize = 18.sp
            ),
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .constrainAs(unitPrice) {
                    linkTo(totalPrice.top, totalPrice.bottom,bias = 0F)
                    linkTo(unitPriceTitle.start, endGuideline, bias = 0F)
                }
        )


    }


}
