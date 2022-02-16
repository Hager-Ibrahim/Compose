package com.example.compose.modules.staff.examples.fifith

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.compose.modules.staff.model.StaffUIModel
import com.example.compose.modules.staff.screen.StaffCard
import com.example.compose.modules.staff.screen.StaffHeader

@Composable
fun StaffList(staffList: List<StaffUIModel>){

    LazyColumn(
        contentPadding = PaddingValues(12.dp)
    ){
        staffList.forEachIndexed() { index,data->
            item {
                if(index in setOf(2,7,9)){
                    StaffHeader()
                }
                StaffCard(staff = data, onClick = {})
            }
        }
    }
}