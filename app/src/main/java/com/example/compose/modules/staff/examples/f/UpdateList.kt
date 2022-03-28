package com.example.compose.modules.staff.examples.f

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.modules.staff.StaffViewModel
import com.example.compose.modules.staff.model.StaffUIModel
import com.example.compose.modules.staff.screen.StaffCard
import com.example.compose.modules.staff.screen.StaffItem

@Composable
fun StaffScreen(viewModel: StaffViewModel) {
    val staffList = remember{viewModel.staffList}


    StaffContent(onClick = {
          viewModel.update(it)
    }, staff = staffList)

}

@Composable
fun StaffContent(onClick: (Int) -> Unit, staff: List<StaffUIModel>){
    LazyColumn(
        contentPadding = PaddingValues(12.dp)
    ) {

        staff.forEachIndexed { index, staff ->
            item {
                StaffCard(staff = staff, index){
                   onClick(index)
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