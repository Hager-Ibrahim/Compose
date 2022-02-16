package com.example.compose.modules.staff.examples.second

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.compose.modules.staff.model.StaffUIModel
import com.example.compose.modules.staff.screen.StaffCard

@Composable
fun StaffList(staffList: List<StaffUIModel>){
    LazyColumn {
        staffList.forEach {
            item {
                StaffCard(staff = it, onClick ={} )
            }
        }
    }
}