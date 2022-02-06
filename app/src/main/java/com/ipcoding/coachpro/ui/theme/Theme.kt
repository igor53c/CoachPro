package com.ipcoding.coachpro.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

private val DarkColorPalette = darkColors(
    primary = DarkGreen,
    primaryVariant = Purple700,
    secondary = Teal200,
    secondaryVariant = Green
)

private val LightColorPalette = lightColors(
    primary = DarkGreen,
    primaryVariant = Purple700,
    secondary = Teal200,
    secondaryVariant = Green

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ProvideDimens(
    dimensions: Dimensions,
    content: @Composable () -> Unit
) {
    val dimensionSet = remember { dimensions }
    CompositionLocalProvider(LocalAppDimens provides dimensionSet, content = content)
}

private val LocalAppDimens = staticCompositionLocalOf { smallDimensions }

@Composable
fun CoachProTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    val screenWidth = LocalContext.current.resources.displayMetrics.widthPixels.dp /
            LocalDensity.current.density

    val typography = when(screenWidth) {
        in 0.dp..390.dp -> smallTypography
        in 391.dp..500.dp -> normalTypography
        in 501.dp..700.dp -> largeTypography
        else -> extraLargeTypography
    }

    val dimensions = when(screenWidth) {
        in 0.dp..390.dp -> smallDimensions
        in 391.dp..500.dp -> normalDimensions
        in 501.dp..700.dp -> largeTDimensions
        else -> extraLargeDimensions
    }


    ProvideDimens(dimensions = dimensions) {
        MaterialTheme(
            colors = colors,
            typography = typography,
            shapes = Shapes,
            content = content
        )
    }
}

object AppTheme {

    val dimens: Dimensions
        @Composable
        get() = LocalAppDimens.current
}