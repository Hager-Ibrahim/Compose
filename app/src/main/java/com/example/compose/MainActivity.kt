package com.example.compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography

import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            AppTheme(false) {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    FirstComposeFun()
                }

            }

        }
    }
}



@Composable
fun FirstComposeFun() {
    Text(
        text = stringResource(id = R.string.hello),
        color = MaterialTheme.colors.primary,
        maxLines = 1,
        textAlign = TextAlign.Center,
        style = typography.h1,
        overflow = TextOverflow.Ellipsis,
    )
}

//
//@Preview("large font", fontScale = 4f,showBackground = true)
//@Preview("full screen",showBackground = true, showSystemUi = true)
//@Preview("locale", locale = "ar",showBackground = true)
//@Preview("default",showBackground = true)



@Composable
fun ComposeFun() {
    Text(
        text = stringResource(id = R.string.hello),
        color = Purple700,
        maxLines = 1,
        textAlign = TextAlign.Center,
        style = TextStyle(
            fontFamily = FontFamily(Font(R.font.cairo_bold)),
            fontSize = 20.sp,
        ),
        overflow = TextOverflow.Ellipsis,
    )
}