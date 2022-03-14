package com.example.compose.modules.staff.examples.f

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.modules.staff.StaffViewModel
import com.example.compose.modules.staff.model.StaffUIModel
import com.example.compose.modules.staff.screen.StaffItem

@Composable
fun UpdateStaff(viewModel: StaffViewModel) {
    val staffList = viewModel.staffList
    val updateStaff: ((Int) -> Unit)= { viewModel.update(it) }

    LazyColumn(
        contentPadding = PaddingValues(12.dp)
    ) {

        staffList.forEachIndexed { index, staff ->
            item {
                StaffCard(staff = staff, index){
                    updateStaff(index)
                }
            }
        }
    }
}

@Composable
fun StaffCard(staff: StaffUIModel,
              position: Int,
              onClick: (StaffUIModel)-> Unit) {
    Log.d("TEST", "StaffCard:  $position")
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                onClick(staff)
            }
    ) {
        StaffItem(staff)
    }
}