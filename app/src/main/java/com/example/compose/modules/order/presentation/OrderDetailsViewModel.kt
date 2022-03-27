package com.example.compose.modules.order.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.compose.R
import com.example.compose.modules.order.presentation.model.CartItemDomainModel
import com.example.compose.modules.order.presentation.model.OrderDetailsUIModel
import com.example.compose.modules.order.presentation.model.OrderInfoModel
import com.example.compose.modules.order.presentation.model.OrderStatus.Companion.getStatus

class OrderDetailsViewModel : ViewModel(){

    private val _orderDetails = MutableLiveData<OrderDetailsUIModel>()
    val orderDetails: LiveData<OrderDetailsUIModel>
        get() = _orderDetails


    init {
        dummyStaffList()
    }

    private fun dummyStaffList() {
        _orderDetails.postValue(
            OrderDetailsUIModel(
                0,
                "3465",
                "pending".getStatus(),
                "22 March 2022",
                "Hager Ibrahim",
                20.55,
                2,
                listOf(
                    CartItemDomainModel(
                    2121,
                        "Nido 200ml",
                        2,
                        10.0,
                        20.0,
                        "image",0,8,9),
                    CartItemDomainModel(
                        12221,
                        "Nutella",
                        3,
                        50.0,
                        150.0,
                        "image",0,8,9)),
                "image",
                "2 Babel street",
                "21 March 2022",
                "Notes",
                "By retailer",
                "Cash in delivery",
                "0108765446",
                 getInfoList()
            )
        )
    }



    private fun getInfoList() = listOf(
            OrderInfoModel( R.string.order_delivery,
                "By retailer",
                 R.drawable.ic_delivery),
            OrderInfoModel(
                R.string.delivery_date,
                "22 March 2022",
                R.drawable.ic_time),
            OrderInfoModel(
                R.string.payment,
                "Cash in delivery",
                R.drawable.ic_wallet,)
        )


}
