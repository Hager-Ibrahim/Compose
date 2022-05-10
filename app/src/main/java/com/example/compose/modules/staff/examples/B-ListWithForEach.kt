package com.example.compose.modules.staff.examples

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.modules.staff.StaffViewModel
import com.example.compose.modules.staff.model.StaffUIModel
import com.example.compose.modules.staff.screen.StaffCard


@Composable
fun ListWithForEach(staffList: List<StaffUIModel>) {
    LazyColumn {
        staffList.forEach {
            item {
                StaffCard(staff = it, onClick = {})
            }
        }
    }
}

@Preview
@Composable
fun PreviewListWithForEach() {
    val viewModel = StaffViewModel()
    val staff = remember { viewModel.staffList }
    ListWithForEach(staff)
}