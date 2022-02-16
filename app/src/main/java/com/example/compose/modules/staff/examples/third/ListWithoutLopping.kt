package com.example.compose.modules.staff.examples.third

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.compose.modules.staff.model.StaffUIModel
import com.example.compose.modules.staff.screen.StaffCard

@Composable
fun StaffList(staffList: List<StaffUIModel>) {
    LazyColumn(contentPadding = PaddingValues(8.dp)) {

        items(staffList) {
            StaffCard(staff = it, onClick = {})
        }

    }
}