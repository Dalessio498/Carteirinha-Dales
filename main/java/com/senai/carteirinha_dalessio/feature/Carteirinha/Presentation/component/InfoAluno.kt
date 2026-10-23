package com.senai.carteirinha_dalessio.feature.Carteirinha.Presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.senai.carteirinha_dalessio.feature.Carteirinha.Presentation.ValueText

@Composable
fun InfoAluno(textLabel: String, textValue: String, modifier: Modifier = Modifier, fontSizeValue: TextUnit = 15.sp,
              fontWeightValue: FontWeight = FontWeight.SemiBold
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        LabelText(
            text = textLabel,
            modifier = Modifier
                .weight(1f)
        )

        ValueText(
            text = textValue,
            modifier = Modifier
                .weight(3f)
        )
    }
}