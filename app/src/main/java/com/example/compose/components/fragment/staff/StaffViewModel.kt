package com.example.compose.components.fragment.staff

import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.compose.components.fragment.staff.model.StaffUIModel

class StaffViewModel : ViewModel(){
    private val _staff = MutableLiveData<List<StaffUIModel>>()
    val staff: LiveData<List<StaffUIModel>>
        get() = _staff

    init {
        dummyStaffList()
    }

    private fun dummyStaffList() {
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

        _staff.postValue(staffList)
    }

    fun removeStaff(staffUIModel: StaffUIModel){
          _staff.value = _staff.value?.toMutableList()?.apply {
              remove(staffUIModel)
          }
    }

    fun updateItem(){
        _staff.value= _staff.value?.toMutableList()?.apply {
            this[0] =  StaffUIModel(
                50,
                "",
                "Custom Staff",
                "Android Developer",true,"2h")
        }
    }

}
