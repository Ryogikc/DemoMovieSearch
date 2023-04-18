package com.leagueofdevs.demomoviesearch.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

 private val LightColorPalette = lightColors(
        primary = Color.Black,
        secondary = rust600,
        background = Color.White,
        surface = purple500.copy(alpha = .40f),
        onPrimary = Color.Blue,
        onSecondary = Color.Black,
        onBackground = Color.Black,
        onSurface = gray900.copy(alpha = 0.8f)
    )

    private val DarkColorPalette = darkColors(
        primary = Color.White,
        secondary = pink300,
        background = gray900,
        surface = Color.White.copy(alpha = 0.15f),
        onPrimary = gray900,
        onSecondary = gray900,
        onBackground = pink50,
        onSurface = Color.White.copy(alpha = .8f)
    )

    @Composable
    fun MovieTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
        val colors = if (darkTheme) {
            DarkColorPalette
        } else {
            LightColorPalette
        }

        MaterialTheme(
            colors = colors,
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
