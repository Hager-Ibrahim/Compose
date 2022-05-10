package com.example.compose.modules.staff.examples

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.compose.R
import com.example.compose.modules.staff.model.Product
import com.example.compose.modules.staff.model.ProductPreviewParameterProvider
import com.example.compose.ui.theme.*


@Composable
fun AdvancedExample(product: Product) {
    Card(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp)),

    ) {

        ConstraintLayout(
            modifier =
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Grey)
        ) {

            val (productImage, productName, wholesalerImage, soldBy, price) = createRefs()

            val topGuideLine = createGuidelineFromTop(16.dp)
            val bottomGuideLine = createGuidelineFromBottom(16.dp)
            val startGuideline = createGuidelineFromStart(dimensionResource(id = R.dimen.guide_screen_spacer))
            val endGuideline = createGuidelineFromEnd(dimensionResource(id = R.dimen.guide_screen_spacer))

            Image(painter = painterResource(id = R.drawable.ic_kuzlo_placeholder),
                contentDescription = "",
                modifier = Modifier
                    .clip(CircleShape)
                    .requiredHeight(86.dp)
                    .requiredWidth(86.dp)
                    .constrainAs(productImage) {
                        linkTo(topGuideLine, bottomGuideLine)
                        start.linkTo(startGuideline)
                    })

            Text(
                text = product.productName,
                style = TextStyle(
                    color = Shark,
                    fontFamily = FontFamily(Font(R.font.cairo_regular)),
                    fontSize = 16.sp
                ),
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .constrainAs(productName) {
                        linkTo(topGuideLine, wholesalerImage.bottom)
                        linkTo(productImage.end, endGuideline, startMargin = 8.dp, bias = 0F)
                        //app:layout_constrainedWidth="true"
                        width = Dimension.preferredWrapContent
                    },
                maxLines = 1,
                overflow = TextOverflow.Ellipsis

            )

            Image(painter = painterResource(id = R.drawable.ic_kuzlo_placeholder),
                contentDescription = "",
                modifier = Modifier
                    .clip(CircleShape)
                    .requiredHeight(16.dp)
                    .requiredWidth(16.dp)
                    .constrainAs(wholesalerImage) {
                        linkTo(productName.bottom, price.bottom, topMargin = 8.dp)
                        start.linkTo(productName.start)
                    })

            Text(
                text = "Sold by ${product.wholesalerName}",
                style = TextStyle(
                    color = SantasGrey,
                    fontFamily = FontFamily(Font(R.font.cairo_regular)),
                    fontSize = 12.sp
                ),
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .constrainAs(soldBy) {
                        linkTo(wholesalerImage.top, wholesalerImage.bottom)
                        linkTo(wholesalerImage.end, endGuideline, startMargin = 8.dp, bias = 0F)
                        width = Dimension.preferredWrapContent
                    },
                maxLines = 1,
                overflow = TextOverflow.Ellipsis

            )

            Text(
                text = "20 L.E",
                style = TextStyle(
                    color = Flamingo,
                    fontFamily = FontFamily(Font(R.font.cairo_bold)),
                    fontSize = 14.sp
                ),
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .constrainAs(price) {
                        linkTo(wholesalerImage.bottom, bottomGuideLine, topMargin = 8.dp)
                        linkTo(wholesalerImage.start, endGuideline, bias = 0F)
                    }


            )

            createVerticalChain(
                productName, wholesalerImage,price,
                chainStyle = ChainStyle.Packed
            )

        }

    }

}


@Preview
@Composable
fun ProductPreview(
    @PreviewParameter(ProductPreviewParameterProvider::class) product: Product){

    AdvancedExample(product = product)
}