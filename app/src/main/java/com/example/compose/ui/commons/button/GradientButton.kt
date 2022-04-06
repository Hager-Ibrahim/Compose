package com.example.compose.ui.commons.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun GradientButton(
    gradient: Brush,
    isEnabled: Boolean = false,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    Button(
        modifier= Modifier.clip(shape = RoundedCornerShape(24.dp)),
        contentPadding = PaddingValues(),
        enabled = isEnabled,
        onClick = { onClick() })
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(gradient)
                .graphicsLayer { alpha = if(isEnabled) 1f else 0.5F}
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center,
        ) {
            content()
        }
    }
}