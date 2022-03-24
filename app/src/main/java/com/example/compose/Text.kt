package com.example.compose

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.sp

//@Preview(showBackground = true)

@Composable
fun ComposeFun(text: String) {
    Text(
        text = text,
        color = MaterialTheme.colors.primary,
        maxLines = 1,
        textAlign = TextAlign.Center,
        style = TextStyle(
            fontFamily = FontFamily(Font(R.font.cairo_bold)),
            fontSize = 20.sp,
        ),
        overflow = TextOverflow.Ellipsis,
    )
}



//@Preview(showBackground = true)
//@Composable
//fun ForthComposeFunPreview(){
//    ComposeFun("Text")
//}
//







//@Preview(showBackground = true)
//@Composable
//fun ForthComposeFunPreviewOptions(@PreviewParameter(NameProvider::class) name: String){
//    ComposeFun(name)
//}
//
//
//
//class NameProvider: PreviewParameterProvider<String> {
//    override val values: Sequence<String> = sequenceOf(
//        "Short text",
//        "Long Textttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt"
//    )
//}

