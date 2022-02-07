package com.ipcoding.coachpro.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

private val DarkAppColorPalette = darkAppColors()

private val LightAppColorPalette = lightAppColors()

private val LocalAppTypography = staticCompositionLocalOf { NormalTypography }

private val LocalAppColors = staticCompositionLocalOf { LightAppColorPalette }

private val LocalAppDimens = staticCompositionLocalOf { NormalDimensions }

private val LocalAppShapes = staticCompositionLocalOf { NormalShapes }

@Composable
fun CoachProTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) DarkAppColorPalette else LightAppColorPalette

    val screenWidth = LocalContext.current.resources.displayMetrics.widthPixels.dp /
            LocalDensity.current.density

    val typography = when(screenWidth) {
        in 0.dp..390.dp -> smallTypography
        in 391.dp..500.dp -> NormalTypography
        in 501.dp..700.dp -> largeTypography
        else -> extraLargeTypography
    }

    val dimensions = when(screenWidth) {
        in 0.dp..390.dp -> SmallDimensions
        in 391.dp..500.dp -> NormalDimensions
        in 501.dp..700.dp -> LargeDimensions
        else -> ExtraLargeDimensions
    }

    val shapes = when(screenWidth) {
        in 0.dp..390.dp -> SmallShapes
        in 391.dp..500.dp -> NormalShapes
        in 501.dp..700.dp -> LargeShapes
        else -> ExtraLargeShapes
    }

    AppTheme(
        colors = colors,
        typography = typography,
        dimensions = dimensions,
        shapes = shapes,
        content = content
    )
}

@Composable
fun AppTheme(
    colors: AppColors = AppTheme.colors,
    typography: Typography = AppTheme.typography,
    dimensions: Dimensions = AppTheme.dimensions,
    shapes: Shapes = AppTheme.shapes,
    content: @Composable () -> Unit
) {
    val rememberedColors = remember { colors.copy() }.apply { updateColorsFrom(colors) }
    CompositionLocalProvider(
        LocalAppColors provides rememberedColors,
        LocalAppDimens provides dimensions,
        LocalAppTypography provides typography,
        LocalAppShapes provides shapes
    ) {
        content()
    }
}

object AppTheme {

    val typography: Typography
        @Composable
        get() = LocalAppTypography.current

    val colors: AppColors
        @Composable
        get() = LocalAppColors.current

    val dimensions: Dimensions
        @Composable
        get() = LocalAppDimens.current

    val shapes: Shapes
        @Composable
        get() = LocalAppShapes.current
}