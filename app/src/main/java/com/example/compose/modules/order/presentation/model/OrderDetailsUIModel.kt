package com.example.compose.modules.order.presentation.model

data class OrderDetailsUIModel(

    val id: Int,
    val orderNumber: String,
    val status: OrderStatus,
    val expectedDeliveryDate: String?,
    val wholesalerName: String?,
    val totalPrice: Double?,
    val numberOfProducts: Int,
    val items: List<CartItemDomainModel>,
    val wholesalerLogo: String?,
    val deliveryAddress: String,
    val orderCreationDate: String,
    val deliveryNotes: String,
    val deliveryMethod: String,
    val paymentMethod: String,
    val retailerPhoneNumber: String,
    val orderInfo : List<OrderInfoModel>

)