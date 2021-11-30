package com.example.compose.components.fragment.staff.screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.components.fragment.staff.model.StaffUIModel

@Composable
fun StaffCard(staff: StaffUIModel, onClick: (StaffUIModel)-> Unit) {
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