package com.senai.carteirinha_dalessio.Core.designSystem.Theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = SenaiRed,
    onPrimary = Color.White,

    primaryContainer = Color(0xFFFFE4E6),
    onPrimaryContainer = SenaiRedDark,

    secondary = SenaiText,
    onSecondary = Color.White,

    background = SenaiBackground,
    onBackground = SenaiText,

    surface = SenaiSurface,
    onSurface = SenaiText,

    surfaceVariant = SenaiSurfaceVariant,
    onSurfaceVariant = SenaiTextSecondary,

    outline = SenaiBorder
)

private val DarkColorScheme = darkColorScheme(
    primary = SenaiRedLight,
    onPrimary = Color.White,

    primaryContainer = SenaiRedDark,
    onPrimaryContainer = Color.White,

    secondary = Color.White,

    background = SenaiDarkBackground,
    onBackground = Color.White,

    surface = SenaiDarkSurface,
    onSurface = Color.White,

    surfaceVariant = SenaiDarkSurfaceVariant,
    onSurfaceVariant = Color(0xFFB7B7BD),

    outline = Color(0xFF3D3F45)
)

@Composable
fun CarteirinhaDalessioTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = Typography,
        content = content
    )
}