package com.example.compose.modules.order.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R
import com.example.compose.modules.order.presentation.OrderDetailsViewModel
import com.example.compose.modules.order.presentation.model.OrderDetailsUIModel
import com.example.compose.ui.theme.TitanWhite


@Composable
fun OrderDetailsScreen(orderViewModel: OrderDetailsViewModel) {

    val orderUIModel by orderViewModel.orderDetails.observeAsState()

    OrderDetailsContent(orderUIModel = orderUIModel)

}

@Composable
fun OrderDetailsContent(orderUIModel: OrderDetailsUIModel?) {
    Column(
        modifier = Modifier
            .background(TitanWhite)
            .padding(horizontal = 16.dp)) {

        OrderDetailsText()

        OrderDetailsList(orderUIModel)
    }
}

@Composable
fun OrderDetailsList(orderUIModel: OrderDetailsUIModel?) {
    orderUIModel?.let { order ->
        LazyColumn(Modifier.background(Color.White)) {

            // Order status
            item {
                OrderStatus(order)
            }
            // total products
            item {
                ProductCount(order)
            }
            // wholesaler header
            item {
                WholesalerHeader(order)
            }
            // orders list
            order.items.forEach {
                item {
                    OrderItem(it)
                }
            }
            // order info
            order.orderInfo.forEach {
                item {
                    OrderInfo(it)
                }
            }

            item {
                OrderTotalPrice(order)
            }
        }
    }
}

@Composable
fun ColumnScope.OrderDetailsText(){
    Text(
        stringResource(id = R.string.order_details),
        style = TextStyle(
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.cairo_bold)),
            fontSize = 18.sp
        ),
        modifier = Modifier.align(CenterHorizontally).padding(16.dp)
    )
}