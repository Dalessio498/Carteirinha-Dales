package com.senai.carteirinha_dalessio.feature.Carteirinha.Presentation.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun LabelText(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        text = text,
        fontSize = 30.sp,
        color = Color.Red,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}