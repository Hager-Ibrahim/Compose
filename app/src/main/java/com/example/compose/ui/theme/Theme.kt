package com.example.compose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color.White,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = Color.Black,
    surface = Color.Black,
)

private val LightColorPalette = lightColors(
    primary = Color.Black,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = Color.Black,
    surface = Color.White,


    /* Other default colors to override
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun AppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

//    MaterialTheme.colors.primary
//    MaterialTheme.shapes.large
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

//@Composable
//fun AppTheme2(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
//    val colors = if (darkTheme) {
//        DarkColorPalette
//    } else {
//        LightColorPalette
//    }
//
//    CompositionLocalProvider(localSpacing provides Spacing()) {
//        MaterialTheme(
//            colors = colors,
//            typography = Typography,
//            shapes = Shapes,
//            content = content
//        )
//    }
//
//}