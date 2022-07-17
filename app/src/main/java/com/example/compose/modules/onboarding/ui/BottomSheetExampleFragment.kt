package com.example.compose.modules.onboarding.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.compose.modules.onboarding.ui.compsables.BottomSheet
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class BottomSheetExampleFragment : Fragment() {


    @OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialApi::class)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply {
            setContent {


                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val sheetState = rememberBottomSheetState(
                        initialValue = BottomSheetValue.Collapsed
                    )
                    val scaffoldState = rememberBottomSheetScaffoldState(
                        bottomSheetState = sheetState
                    )
                    val scope = rememberCoroutineScope()

                    Column() {
                        OpenBottomSheetButton(scope = scope, sheetState = sheetState)
                        BottomSheet(scaffoldState)

                    }
                }
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun OpenBottomSheetButton(
        scope: CoroutineScope,
        sheetState: BottomSheetState
    ) {
        Button(onClick = {
            scope.launch {
                if (sheetState.isCollapsed) {
                    sheetState.expand()
                } else {
                    sheetState.collapse()
                }
            }
        }) {
            Text(text = if(sheetState.isCollapsed) "Closed" else "Opened" )
        }

    }
}