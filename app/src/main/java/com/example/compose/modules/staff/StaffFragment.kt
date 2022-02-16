package com.example.compose.modules.staff

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.ViewModelProvider


class StaffFragment : Fragment() {

    private lateinit var viewModel: StaffViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(StaffViewModel::class.java)

        return ComposeView(requireContext()).apply {
            setContent {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val staff = viewModel.staff.observeAsState().value ?: arrayListOf()
                    LazyColumn {
                        staff.forEach {

                        }
                    }
                }
            }
        }
    }
}
//StaffCard(staff = it, onClick ={} )



//StaffCard(staff = it, onClick = {
//    viewModel.removeStaff(it)
//})