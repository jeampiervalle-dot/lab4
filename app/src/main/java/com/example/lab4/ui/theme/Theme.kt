package com.example.lab4.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = MochaBlue,
    secondary = MochaLavender,
    tertiary = MochaMauve,
    background = MochaBase,
    surface = MochaMantle,
    surfaceVariant = MochaSurface0,
    onPrimary = MochaCrust,
    onSecondary = MochaCrust,
    onTertiary = MochaCrust,
    onBackground = MochaText,
    onSurface = MochaText,
    error = MochaRed,
    onError = MochaCrust,
)

private val LightColorScheme = lightColorScheme(
    primary = LatteBlue,
    secondary = LatteLavender,
    tertiary = LatteMauve,
    background = LatteBase,
    surface = LatteMantle,
    surfaceVariant = LatteSurface0,
    onPrimary = LatteCrust,
    onSecondary = LatteCrust,
    onTertiary = LatteCrust,
    onBackground = LatteText,
    onSurface = LatteText,
    error = LatteRed,
    onError = LatteCrust,
)

@Composable
fun Lab4Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
