package com.example.compose.modules.fragment.staff.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.modules.staff.StaffViewModel
import com.example.compose.ui.theme.presenration.text.DefaultText

@Composable
fun StaffScreen(viewModel: StaffViewModel){
    val staff = viewModel.staff.observeAsState().value ?: arrayListOf()
    Column(Modifier.background(Color.White)) {

        DefaultText(
            text = "ALL STAFF",
            color = Color(0xFF354b60),
            fontSize =20.sp ,
            modifier = Modifier.padding(16.dp))

        LazyColumn (contentPadding = PaddingValues(horizontal = 12.dp)){
            items(staff){
                StaffCard(staff = it, onClick = {})
            }
        }  
    }

}