package com.example.compose.modules.order.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R
import com.example.compose.modules.order.presentation.model.OrderDetailsPreviewParameterProvider
import com.example.compose.modules.order.presentation.model.OrderDetailsUIModel
import com.example.compose.modules.order.presentation.model.OrderStatus.Companion.getStatus
import com.example.compose.ui.theme.*


@Composable
fun WholesalerHeader(order: OrderDetailsUIModel) {

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
            painter = painterResource(id = R.drawable.ic_kuzlo_placeholder),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .requiredHeight(30.dp)
                .requiredWidth(30.dp)

        )

        Text(
            text = order.wholesalerName ?:"",
            style = TextStyle(
                color = Tangerine,
                fontFamily = FontFamily(Font(R.font.cairo_bold)),
                fontSize = 16.sp
            ),
            modifier = Modifier
                .padding(start = 12.dp, end = 4.dp)
                .wrapContentHeight()
                .wrapContentWidth(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis

        )


        Text(
            text = "(${order.numberOfProducts})",
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

@Preview(showBackground = true)
@Composable
fun WholesalerHeaderPreview(
    @PreviewParameter(OrderDetailsPreviewParameterProvider::class)
                              order: OrderDetailsUIModel) {
    WholesalerHeader(order)
}