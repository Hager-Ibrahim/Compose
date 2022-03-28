package com.example.compose.ui.commons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.compose.R

@ExperimentalCoilApi
@Composable
fun Coil(){

    val painter = rememberImagePainter(
        data =
        "https://kuzlo-staging-uploads.s3.amazonaws.com/wholesalers_logos/1645459637095_145KB.jpg"
        , builder ={
            placeholder(R.drawable.ic_kuzlo_placeholder)
            error(R.drawable.ic_kuzlo_placeholder)
        })

    Image(
        painter = painter,
        contentDescription = "",
        modifier = Modifier
            .requiredHeight(100.dp)
            .requiredWidth(100.dp),
        contentScale = ContentScale.Crop
    )

//    when(painter.state){
//        is Loading->{
//            CircularProgressIndicator(
//                modifier = Modifier.requiredWidth(10.dp))
//        }
//        is Error->{
//
//        }
//        else -> {}
//    }
//    CoilImage(
//        imageModel = "imageUrl",
//        // Crop, Fit, Inside, FillHeight, FillWidth, None
//        contentScale = ContentScale.Crop,
//        // shows a placeholder ImageBitmap when loading.
//        placeHolder = painterResource(R.drawable.ic_kuzlo_placeholder),
//        // shows an error ImageBitmap when the request failed.
//        error = painterResource(R.drawable.ic_kuzlo_placeholder),
//        modifier = Modifier.requiredWidth(100.dp).requiredHeight(100.dp)
//
//    )
}