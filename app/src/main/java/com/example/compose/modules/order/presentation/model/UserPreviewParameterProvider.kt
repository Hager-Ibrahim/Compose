package com.example.compose.modules.order.presentation.model

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.compose.modules.order.presentation.model.OrderStatus.Companion.getStatus

class OrderDetailsPreviewParameterProvider : PreviewParameterProvider<OrderDetailsUIModel> {
    override val values = sequenceOf(
        OrderDetailsUIModel(
            0,
            "3465",
            "pending".getStatus(),
            "22 March 2022",
            "Hager Ibrahim",
            20.55,
            2,
            listOf(),
            "image",
            "2 Babel street",
            "21 March 2022",
            "Notes",
            "By retailer",
            "Cash in delivery",
            "0108765446",
            listOf()
        )
    )
}
