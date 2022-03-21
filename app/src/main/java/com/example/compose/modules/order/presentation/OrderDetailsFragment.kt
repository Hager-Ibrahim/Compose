package com.example.compose.modules.order.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.ViewModelProvider
import com.example.compose.modules.order.presentation.screen.*


class OrderDetailsFragment : Fragment() {

    private lateinit var viewModel: OrderDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(OrderDetailsViewModel::class.java)

        return ComposeView(requireContext()).apply {
            setContent {
                val staff = viewModel.staffList

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //StaffList(staffList = staff)
                   // UpdateStaff(viewModel)
                   // OrderItem()
                   // WholesalerHeader()
                    //ProductCount()
                    OrderInfo()
                }
            }
        }
    }
}