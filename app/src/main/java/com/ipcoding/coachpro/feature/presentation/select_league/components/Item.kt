package com.ipcoding.coachpro.feature.presentation.select_league.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun Item(
    modifier: Modifier = Modifier,
    title: String,
    colorText: Color = AppTheme.colors.primary,
    colorBackground: Color = AppTheme.colors.background
) {
    Box(modifier = modifier) {
        Text(
            text = title,
            style = AppTheme.typography.h6,
            color = colorText,
            modifier = Modifier
                .border(
                    border = BorderStroke(
                        width = AppTheme.dimensions.spaceSuperSmall,
                        color = AppTheme.colors.primary
                    ),
                    shape = AppTheme.shapes.medium
                )
                .background(
                    color = colorBackground,
                    shape = AppTheme.shapes.medium
                )
                .padding(AppTheme.dimensions.spaceMedium)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}