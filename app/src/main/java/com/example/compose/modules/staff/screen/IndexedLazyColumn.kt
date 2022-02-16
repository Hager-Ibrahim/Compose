package com.example.compose.modules.staff.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.compose.modules.staff.StaffViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun IndexedLazyColumn(viewModel: StaffViewModel) {
    val staff = viewModel.staff.observeAsState().value

    LazyColumn(
        contentPadding = PaddingValues(12.dp)
    ){
        staff?.forEachIndexed() { index,data->
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
    val staff = viewModel.staff.observeAsState().value ?: emptyList()

    LazyColumn(
    contentPadding = PaddingValues(12.dp)
    ) {
        item {
            StaffHeader()
        }
        items(staff) { staff ->
            StaffCard(staff){
                viewModel.removeStaff(it)
            }

        }
    }
}