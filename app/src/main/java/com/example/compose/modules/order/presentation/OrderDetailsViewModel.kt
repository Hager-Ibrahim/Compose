package com.example.compose.modules.order.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.compose.modules.order.presentation.model.StaffUIModel

class OrderDetailsViewModel : ViewModel(){

    var staffList = mutableStateListOf<StaffUIModel>()
    init {
        dummyStaffList()
    }

    private fun dummyStaffList() {
        val list = ArrayList<StaffUIModel>().apply {
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

        staffList.addAll(list)
    }


    fun update(index: Int){
        staffList[index] = staffList[index].copy(jobTitle = "Updated!")
    }

}
