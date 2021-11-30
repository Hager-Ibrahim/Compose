package com.example.compose.components.fragment.staff.model

data class StaffUIModel(
    val id: Int,
    val image: String,
    val name: String,
    val jobTitle: String,
    val isIn: Boolean,
    val todayTime: String,
)