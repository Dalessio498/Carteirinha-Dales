package com.senai.carteirinha_dalessio.Core.designSystem.Theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = PortalBlue,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFDCEAFF),
    onPrimaryContainer = PortalBlueDark,

    secondary = PortalOrange,
    onSecondary = Color(0xFF231200),
    secondaryContainer = Color(0xFFFFE5CC),
    onSecondaryContainer = Color(0xFF683100),

    tertiary = PortalOrange,
    onTertiary = Color(0xFF231200),

    background = PortalBackground,
    onBackground = PortalText,
    surface = PortalSurface,
    onSurface = PortalText,
    surfaceVariant = PortalSurfaceVariant,
    onSurfaceVariant = PortalTextSecondary,
    outline = PortalBorder,
    error = Color(0xFFB42318)
)

private val DarkColorScheme = darkColorScheme(
    primary = PortalBlueLight,
    onPrimary = PortalBlueDark,
    primaryContainer = PortalBlue,
    onPrimaryContainer = Color.White,

    secondary = PortalOrangeLight,
    onSecondary = Color(0xFF482100),
    secondaryContainer = Color(0xFF66350C),
    onSecondaryContainer = Color(0xFFFFE5CC),

    tertiary = PortalOrangeLight,
    onTertiary = Color(0xFF482100),

    background = PortalDarkBackground,
    onBackground = Color(0xFFF3F6FF),
    surface = PortalDarkSurface,
    onSurface = Color(0xFFF3F6FF),
    surfaceVariant = PortalDarkSurfaceVariant,
    onSurfaceVariant = Color(0xFFC0CEDE),
    outline = Color(0xFF4B617D),
    error = Color(0xFFFFB4AB)
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
