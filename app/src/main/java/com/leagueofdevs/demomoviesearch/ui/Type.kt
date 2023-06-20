package com.leagueofdevs.demomoviesearch.ui

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.leagueofdevs.demomoviesearch.R

private val fontFamilyRaleway = FontFamily(
    listOf(
        Font(
            resId = R.font.raleway_regular
        ),
        Font(
            resId = R.font.raleway_light,
            weight = FontWeight.Light
        ),
        Font(
            resId = R.font.raleway_bold
        ),
    )
)

val typography = Typography(
    h2 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
        fontFamily = fontFamilyRaleway,
        letterSpacing = 0.sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        fontFamily = fontFamilyRaleway,
        letterSpacing = 0.sp
    ),
    h4 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        fontFamily = fontFamilyRaleway,
        letterSpacing = 0.sp
    ),
    body1 = TextStyle(
        fontSize = 14.sp,
        fontFamily = fontFamilyRaleway,
        letterSpacing = 0.sp
    ),
    body2 = TextStyle(
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        fontFamily = fontFamilyRaleway,
        color = Color.Black
    ),
)
