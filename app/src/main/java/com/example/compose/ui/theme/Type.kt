package com.example.compose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.R


val regular = FontFamily(Font(R.font.cairo_regular))
val semiBold =  FontFamily(Font(R.font.cairo_semi_bold))
val bold =  FontFamily(Font(R.font.cairo_bold))


// Set of Material typography styles to start with
val Typography = Typography(
    h1= TextStyle(
        fontFamily = bold,
        fontSize = 20.sp,
    ),
    h2= TextStyle(
        fontFamily = bold,
        fontSize = 18.sp,
    ),

    subtitle1= TextStyle(
        fontFamily = semiBold,
        fontSize = 16.sp,
    ),
    subtitle2= TextStyle(
        fontFamily = semiBold,
        fontSize = 14.sp,
    ),
    body1 = TextStyle(
        fontFamily = regular,
        fontSize = 14.sp,
    ),
    button = TextStyle(
        fontFamily = regular,
        fontSize = 14.sp,
        color = Teal200
    ),
    /* Other default text styles to override
    body3 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)