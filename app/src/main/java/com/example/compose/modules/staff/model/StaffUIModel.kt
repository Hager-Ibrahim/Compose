package com.example.compose.modules.staff.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StaffUIModel(
    val id: Int,
    val image: String,
    val name: String,
    val jobTitle: String,
    val isIn: Boolean,
    val todayTime: String,
): Parcelable