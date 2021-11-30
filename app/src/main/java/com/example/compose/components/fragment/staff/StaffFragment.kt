package com.example.compose.components.fragment.staff

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.compose.components.fragment.staff.screen.IndexedLazyColumn
import com.example.compose.components.fragment.staff.screen.StaffCard
import com.example.compose.components.fragment.staff.screen.StaffHeader
import com.example.compose.components.fragment.staff.screen.UpdateStaff


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
                    val staff = viewModel.staff.observeAsState().value
                    LazyColumn {
                        staff?.forEach {
                            item {
                                StaffCard(staff = it, onClick = {
                                    viewModel.removeStaff(it)
                                })
                            }
                        }

                    }
                }
            }
        }
    }
}