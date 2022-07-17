package com.example.compose.ui.commons.bottomsheet

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomBottomSheet(bottomSheetScaffoldState: BottomSheetScaffoldState,
                      sheetContent: @Composable ColumnScope.() -> Unit) {

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
           sheetContent()
        },
        sheetBackgroundColor = Color.Gray,
        sheetPeekHeight = 0.dp,
        sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
    ) {}
}