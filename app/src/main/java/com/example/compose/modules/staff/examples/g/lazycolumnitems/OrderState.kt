package com.example.compose.modules.staff.examples.g.lazycolumnitems

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintLayoutScope
import androidx.constraintlayout.compose.Dimension
import com.example.compose.R
import com.example.compose.ui.theme.*

@Preview
@Composable
fun OrderState() {

    Box(
        Modifier
            .padding(12.dp)
            .wrapContentHeight()
            .fillMaxWidth()
            .border(1.dp, Tangerine, RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(18.dp))
            .background(TitanWhite)
            .padding(top = 8.dp, bottom = 8.dp, end = 12.dp,)
    ) {
        ConstraintLayout() {

            val (
                orderNo,
                dotOne,
                deliveryAddressTitle,
                deliveryAddress,
                phoneNumTitle,
                phoneNum,
                dotTwo,
                orderDateTitle,
                orderDate,
                dotThree,
                orderStatusTitle,
                orderStatus,
                dotFour,
                line) = createRefs()

            val topGuideline = createGuidelineFromTop(4.dp)
            val bottomGuideline = createGuidelineFromBottom(4.dp)
            val startGuideline = createGuidelineFromStart(12.dp)
            val endGuideline = createGuidelineFromEnd(12.dp)

            Text(
                text = "Order No #4576",
                style = TextStyle(
                    color = Martinique,
                    fontFamily = FontFamily(Font(R.font.cairo_bold)),
                    fontSize = 18.sp
                ),
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .constrainAs(orderNo) {
                        linkTo(topGuideline, bottomGuideline, bias = 0F)
                        linkTo(startGuideline, endGuideline, startMargin = 28.dp, bias = 0F)
                    }
            )

            Text(
                text = "Delivery address",
                style = TextStyle(
                    color = Martinique,
                    fontFamily = FontFamily(Font(R.font.cairo_bold)),
                    fontSize = 18.sp
                ),
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .constrainAs(deliveryAddressTitle) {
                        linkTo(orderNo.bottom, phoneNumTitle.top)
                        start.linkTo(orderNo.start)
                    }
            )

            Text(
                text = "3 address",
                style = TextStyle(
                    color = DustyGrey,
                    fontFamily = FontFamily(Font(R.font.cairo_regular)),
                    fontSize = 16.sp
                ),
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .constrainAs(deliveryAddress) {
                        linkTo(deliveryAddressTitle.top, deliveryAddressTitle.bottom)
                        linkTo(deliveryAddressTitle.end, endGuideline, startMargin = 8.dp, bias = 0F)
                    }
            )

            Dot(modifier = Modifier.constrainAs(dotOne) {
                linkTo(deliveryAddressTitle.top, deliveryAddressTitle.bottom)
                linkTo(startGuideline, endGuideline, bias = 0F)
            })

            Text(
                text = "Phone Number",
                style = TextStyle(
                    color = Martinique,
                    fontFamily = FontFamily(Font(R.font.cairo_bold)),
                    fontSize = 18.sp
                ),
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .constrainAs(phoneNumTitle) {
                        linkTo(deliveryAddress.bottom, orderDateTitle.top, topMargin = 8.dp)
                        linkTo(orderNo.start, phoneNum.start)
                    }
            )

            Text(
                text = "01098654456",
                style = TextStyle(
                    color = DustyGrey,
                    fontFamily = FontFamily(Font(R.font.cairo_regular)),
                    fontSize = 16.sp
                ),
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .constrainAs(phoneNum) {
                        linkTo(phoneNumTitle.top, phoneNumTitle.bottom)
                        linkTo(phoneNumTitle.end, endGuideline, startMargin = 8.dp, bias = 0F)
                    }
            )

            Dot(modifier = Modifier.constrainAs(dotTwo) {
                linkTo(phoneNumTitle.top, phoneNumTitle.bottom)
                linkTo(startGuideline, endGuideline, bias = 0F)
            })


            Text(
                text = "Order date",
                style = TextStyle(
                    color = Martinique,
                    fontFamily = FontFamily(Font(R.font.cairo_bold)),
                    fontSize = 18.sp
                ),
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .constrainAs(orderDateTitle) {
                        linkTo(phoneNumTitle.bottom, orderStatusTitle.top, topMargin = 8.dp)
                        start.linkTo(orderNo.start)
                    }
            )

            Text(
                text = "26 Feb 2022",
                style = TextStyle(
                    color = DustyGrey,
                    fontFamily = FontFamily(Font(R.font.cairo_regular)),
                    fontSize = 16.sp
                ),
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .constrainAs(orderDate) {
                        linkTo(orderDateTitle.top, orderDateTitle.bottom)
                        linkTo(orderDateTitle.end, endGuideline, startMargin = 8.dp, bias = 0F)
                    }
            )

            Dot(modifier = Modifier.constrainAs(dotThree) {
                linkTo(orderDateTitle.top, orderDateTitle.bottom)
                linkTo(startGuideline, endGuideline, bias = 0F)
            })

            Text(
                text = "Order Status",
                style = TextStyle(
                    color = Martinique,
                    fontFamily = FontFamily(Font(R.font.cairo_bold)),
                    fontSize = 18.sp
                ),
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .constrainAs(orderStatusTitle) {
                        linkTo(orderDateTitle.bottom, bottomGuideline, topMargin = 8.dp, bias = 0F)
                        start.linkTo(orderNo.start)
                    }
            )

            Text(
                text = "In Review",
                style = TextStyle(
                    color = Red,
                    fontFamily = FontFamily(Font(R.font.cairo_bold)),
                    fontSize = 18.sp
                ),
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .constrainAs(orderStatus) {
                        linkTo(orderStatusTitle.top, orderStatusTitle.bottom)
                        linkTo(orderStatusTitle.end, endGuideline, startMargin = 8.dp, bias = 0F)
                    }
            )

            Dot(modifier = Modifier.constrainAs(dotFour) {
                linkTo(orderStatusTitle.top, orderStatusTitle.bottom)
                linkTo(startGuideline, endGuideline, bias = 0F)
            })

            Divider(
                color = Silver, thickness = 1.dp,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .width(1.dp)
                    .constrainAs(line) {
                        linkTo(dotOne.top, dotFour.bottom,bias = 0F)
                        linkTo(dotOne.start, dotOne.end)
                        height = Dimension.fillToConstraints
                    }
            )

        }


    }
}



@Composable
fun ConstraintLayoutScope.Dot(modifier: Modifier) {
    val customModifier = modifier.then(
        Modifier
            .size(10.dp)
            .clip(CircleShape)
            .background(Silver)
    )
    Box(
        modifier =
        customModifier
    )
}