package com.ipcoding.coachpro.feature.presentation.select_league.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun Item(
    modifier: Modifier = Modifier,
    title: String,
    style: TextStyle = AppTheme.typography.h6,
    colorText: Color = AppTheme.colors.background,
    colorBackground: Color = AppTheme.colors.primary
) {
    Box(modifier = modifier) {
        Text(
            text = title,
            style = style,
            color = colorText,
            modifier = Modifier
                .border(
                    border = BorderStroke(
                        width = AppTheme.dimensions.spaceSuperSmall,
                        color = colorText
                    ),
                    shape = AppTheme.customShapes.roundedCornerShape
                )
                .background(
                    color = colorBackground,
                    shape = AppTheme.customShapes.roundedCornerShape
                )
                .padding(AppTheme.dimensions.spaceMedium)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}