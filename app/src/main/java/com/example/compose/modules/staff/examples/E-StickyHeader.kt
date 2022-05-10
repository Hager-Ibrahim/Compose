package com.example.compose.modules.staff.examples

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.modules.staff.StaffViewModel
import com.example.compose.modules.staff.model.StaffUIModel
import com.example.compose.modules.staff.screen.StaffCard
import com.example.compose.modules.staff.screen.StaffHeader

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StickyHeader(staffList: List<StaffUIModel>) {

    LazyColumn(
        contentPadding = PaddingValues(12.dp)
    ) {
        stickyHeader {
            StaffHeader()
        }
        items(staffList) { staff ->
            StaffCard(staff) {}
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStickyHeader() {
    val viewModel = StaffViewModel()
    val staff = remember { viewModel.staffList }
    StickyHeader(staff)
}