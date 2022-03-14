package com.example.compose.modules.staff.examples.a

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.compose.modules.staff.model.StaffUIModel

@Composable
fun StaffList(staffList: List<StaffUIModel>){
    LazyColumn {
        staffList.forEach {

        }
    }
}