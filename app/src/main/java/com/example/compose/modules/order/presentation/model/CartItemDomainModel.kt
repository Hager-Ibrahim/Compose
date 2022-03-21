package com.example.compose.modules.order.presentation.model

data class CartItemDomainModel(
    val id: Int,
    val name: String,
    val quantity: Int,
    val unitPrice: Double,
    val totalPrice: Double,
    val itemImage: String,
    val minQuantity: Int = 0,
    val maxQuantity: Int = Int.MAX_VALUE,
    val wholesalerProductId: Int,
)
