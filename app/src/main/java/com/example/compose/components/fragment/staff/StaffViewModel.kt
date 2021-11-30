package com.example.compose.components.fragment.staff

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.compose.components.fragment.staff.model.StaffUIModel

class StaffViewModel : ViewModel(){
    var staff by mutableStateOf(dummyStaffList())

    private fun dummyStaffList(): List<StaffUIModel> {
        val staffList = ArrayList<StaffUIModel>().apply {
            for (i in 1..30) {
                add(
                    StaffUIModel(
                        i,
                        "",
                        "Staff $i",
                        "Android Developer",true,"2h")
                )
            }
        }

        return staffList
    }

    fun removeStaff(staffUIModel: StaffUIModel){
          staff = staff.toMutableList().apply {
              remove(staffUIModel)
          }
    }

    fun updateItem(){
        staff= staff.toMutableList().apply {
            this[0] =  StaffUIModel(
                50,
                "",
                "Custom Staff",
                "Android Developer",true,"2h")
        }
    }

}
