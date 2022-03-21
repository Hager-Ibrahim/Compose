package com.example.compose.modules.order.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
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
import com.example.compose.modules.order.presentation.model.OrderInfoModel
import com.example.compose.ui.theme.Martinique


@Composable
fun OrderInfo(orderInfo: OrderInfoModel) {
    ConstraintLayout(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        val (image, infoTitle, infoContent) = createRefs()

        Image(
            painter = painterResource(id = orderInfo.icon),
            contentDescription = "",
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .constrainAs(image) {
                    linkTo(parent.start, parent.end, bias = 0F)
                    linkTo(parent.top, parent.bottom, bias = 0F)
                },


            )

        Text(
            text = stringResource(id = orderInfo.title),
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
                    linkTo(image.end, parent.end, startMargin = 12.dp, bias = 0F)
                }
        )

        Text(
            text = orderInfo.details,
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
                    linkTo(infoTitle.end, parent.end, startMargin = 4.dp, bias = 0F)
                }
        )

    }
}