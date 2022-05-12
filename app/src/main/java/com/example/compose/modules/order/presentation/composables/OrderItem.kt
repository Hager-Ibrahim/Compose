package com.example.compose.modules.order.presentation.composables

import android.text.SpannableStringBuilder
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.core.text.bold
import com.example.compose.R
import com.example.compose.modules.order.presentation.model.CartItemDomainModel
import com.example.compose.ui.commons.extentions.relativeSizeSpan
import com.example.compose.ui.theme.Dawn
import com.example.compose.ui.theme.Martinique
import com.example.compose.ui.theme.Orange
import com.example.compose.ui.theme.TitanWhite



@Composable
fun OrderItem(cartModel: CartItemDomainModel) {
    ConstraintLayout(
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 4.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(16.dp))
            .background(TitanWhite)
    ) {

        val (image, name, quantity, totalPrice, line, unitPriceTitle, unitPrice) = createRefs()
        val topGuideline = createGuidelineFromTop(12.dp)
        val bottomGuideline = createGuidelineFromBottom(12.dp)
        val startGuideline = createGuidelineFromStart(12.dp)
        val endGuideline = createGuidelineFromEnd(12.dp)

        val middleGuideline = createGuidelineFromStart(0.54F)


        Image(
            painter = painterResource(id = R.drawable.ic_kuzlo_placeholder),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .requiredHeight(46.dp)
                .requiredWidth(46.dp)
                .border(1.dp, Color.Black, RoundedCornerShape(12.dp))
                .clip(RoundedCornerShape(12.dp))
                .constrainAs(image) {
                    linkTo(startGuideline, endGuideline, bias = 0F)
                    linkTo(topGuideline, bottomGuideline)
                },
        )

        Text(
            text = cartModel.name,
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
                    linkTo(image.end, endGuideline, startMargin = 12.dp, bias = 0F)
                    width = Dimension.preferredWrapContent
                },
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )

        Text(
            text = getQuantityText(quantity = cartModel.quantity),
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
            text = stringResource(id = R.string.price,cartModel.totalPrice),
            style = TextStyle(
                color = Orange,
                fontFamily = FontFamily(Font(R.font.cairo_regular)),
                fontSize = 18.sp
            ),
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .constrainAs(totalPrice) {
                    linkTo(quantity.bottom, bottomGuideline, bias = 0F)
                    linkTo(name.start, endGuideline, bias = 0F)
                }
        )

        Divider(
            color = Dawn, thickness = 1.dp,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .width(1.dp)
                .constrainAs(line) {
                    linkTo(quantity.top, totalPrice.bottom, bias = 0F)
                    linkTo(middleGuideline, endGuideline, bias = 0F)
                    height = Dimension.fillToConstraints
                }
        )

        Text(
            text = stringResource(id = R.string.unit_price),
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
            text = stringResource(id = R.string.price,cartModel.unitPrice),
            style = TextStyle(
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.cairo_regular)),
                fontSize = 18.sp
            ),
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .constrainAs(unitPrice) {
                    linkTo(totalPrice.top, totalPrice.bottom, bias = 0F)
                    linkTo(unitPriceTitle.start, endGuideline, bias = 0F)
                }
        )

    }


}
@Composable
private fun getQuantityText(quantity: Int)=
    SpannableStringBuilder().append("${stringResource(R.string.quantity)} ")
        .relativeSizeSpan(14, 16) {
            bold {
                append(stringResource(R.string.number, quantity))
            }
        }.toString()

@Preview(showBackground = true)
@Composable
private fun OrderItemPreview(){
    OrderItem(CartItemDomainModel(
        12221,
        stringResource(id = R.string.long_string),
        3,
        50.0,
        150.0,
        "image",0,8,9))
}
