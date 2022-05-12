package com.example.compose.modules.order.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R
import com.example.compose.modules.order.presentation.model.OrderDetailsPreviewParameterProvider
import com.example.compose.modules.order.presentation.model.OrderDetailsUIModel
import com.example.compose.ui.theme.OysterBay


@Composable
fun OrderTotalPrice(
    order: OrderDetailsUIModel
) {
    Text(
        text = stringResource(id = R.string.total_price, order.totalPrice.toString()),
        modifier =
        Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(OysterBay)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        textAlign = TextAlign.Center,
        style = TextStyle(
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.cairo_bold)),
            fontSize = 18.sp
        ),

        )
}

@Preview(showBackground = true)
@Composable
fun OrderTotalPricePreview(
    @PreviewParameter(OrderDetailsPreviewParameterProvider::class)
    order: OrderDetailsUIModel
) {
    OrderTotalPrice(order)
}