package com.example.compose.components.fragment.staff.screen

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.compose.components.fragment.staff.StaffViewModel
import androidx.compose.foundation.lazy.items

@Composable
fun IndexedLazyColumn(viewModel: StaffViewModel) {
    LazyColumn(
        contentPadding = PaddingValues(12.dp)
    ){
        viewModel.staff.forEachIndexed() { index,data->
            item {
                if(index in setOf(2,7,9)){
                    StaffHeader()
                }
                StaffCard(staff = data, onClick = {})
            }
        }
    }
}

@Composable
fun UpdateStaff(viewModel: StaffViewModel) {
    LazyColumn(
    contentPadding = PaddingValues(12.dp)
    ) {
        item {
            StaffHeader()
        }
        items(viewModel.staff) { staff ->
            StaffCard(staff){
                viewModel.removeStaff(it)
            }

        }
    }
}