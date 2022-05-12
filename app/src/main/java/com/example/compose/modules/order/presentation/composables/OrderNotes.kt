package com.example.compose.modules.order.presentation.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R
import com.example.compose.ui.theme.Martinique
import com.example.compose.ui.theme.SilverChalice

@Preview(showBackground = true)
@Composable
fun OrderNotes(){
    
    Column(modifier =
    Modifier
        .wrapContentHeight()
        .padding(horizontal = 12.dp, vertical = 4.dp)

    ) {
        Text(
            text = "Order Notes",
            style = TextStyle(
                color = Martinique,
                fontFamily = FontFamily(Font(R.font.cairo_regular)),
                fontSize = 14.sp
            ),
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()

        )

        Spacer(modifier = Modifier.padding(vertical = 6.dp))

        Text(
            text = stringResource(id = R.string.long_string),
            style = TextStyle(
                color = SilverChalice,
                fontFamily = FontFamily(Font(R.font.cairo_regular)),
                fontSize = 16.sp
            ),
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()

        )

    }
}