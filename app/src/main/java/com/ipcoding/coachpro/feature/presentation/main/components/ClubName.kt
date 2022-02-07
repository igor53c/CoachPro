package com.ipcoding.coachpro.feature.presentation.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun ClubName(
    name: String,
    colorBackground: Color,
    colorText: Color
) {
    Text(
        text = name,
        color = colorText,
        style = AppTheme.typography.h6,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(bottom = AppTheme.dimensions.spaceExtraMedium)
            .fillMaxWidth()
            .border(
                width = AppTheme.dimensions.spaceSuperSmall,
                color = colorText,
                shape = AppTheme.shapes.medium
            )
            .background(
                color = colorBackground,
                shape = AppTheme.shapes.medium
            )
            .padding(AppTheme.dimensions.spaceMedium)
    )
}