package com.example.compose.modules.onboarding.ui.compsables

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.example.compose.ui.commons.bottomsheet.CustomBottomSheet


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetExample(
    bottomSheetScaffoldState: BottomSheetScaffoldState,
) {
    CustomBottomSheet(bottomSheetScaffoldState = bottomSheetScaffoldState) {
        Text(
            text = "Bottom sheet",
            fontSize = 60.sp
        )
    }
}