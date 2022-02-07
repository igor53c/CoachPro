package com.ipcoding.coachpro.feature.presentation.choose_color_jersey.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun OneColor(
    color: Color,
    border: Color,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .size(AppTheme.dimensions.spaceLarge, AppTheme.dimensions.spaceLarge)
            .padding(AppTheme.dimensions.spaceExtraSmall)
            .drawBehind {
                drawCircle(color = color)
                drawCircle(color = border, style = Stroke(3f))
            }
    )
}