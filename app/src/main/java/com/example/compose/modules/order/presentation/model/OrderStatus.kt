package com.example.compose.modules.order.presentation.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.example.compose.R
import com.example.compose.ui.theme.Red
import com.example.compose.ui.theme.Tangerine

sealed class OrderStatus(@StringRes val name: Int, @DrawableRes val icon: Int, @StringRes val hint: Int? = null, @StringRes val dateHint: Int, val color: Color) {
    object PendingWholesalerConfirmation: OrderStatus(R.string.pending_wholesaler_confirmation, R.drawable.ic_order_check, hint = R.string.we_will_review_and_confirm_it_in_a_few_minutes, dateHint = R.string.delivery_date, color = Tangerine)
    object InProgress: OrderStatus(R.string.in_progress, R.drawable.ic_order_in_progress, dateHint = R.string.delivery_date, color = Tangerine)
    object OutForDelivery: OrderStatus(R.string.out_for_delivery, R.drawable.ic_order_out_for_delivery, dateHint = R.string.delivery_date, color = Tangerine)
    object Delivered: OrderStatus(R.string.delivered, R.drawable.ic_order_sent, dateHint = R.string.delivery_date, color = Tangerine)
    object Cancelled: OrderStatus(R.string.cancelled, R.drawable.ic_order_rejected, dateHint = R.string.request_cancellation_date, color = Red)
    object Rejected: OrderStatus(R.string.rejected, R.drawable.ic_order_rejected, dateHint = R.string.request_cancellation_date, color = Red)

    companion object {
        fun String.getStatus(): OrderStatus {
            return when(this) {
                "in_progress" -> InProgress
                "out_for_delivery" -> OutForDelivery
                "delivered" -> Delivered
                "cancelled" -> Cancelled
                "rejected" -> Rejected
                else -> PendingWholesalerConfirmation
            }
        }
    }

}