package com.ipcoding.coachpro.feature.presentation.main.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
            .fillMaxWidth()
            .padding(AppTheme.dimensions.spaceMedium)
            .border(
                border = BorderStroke(
                    width = AppTheme.dimensions.spaceSuperSmall,
                    color = AppTheme.colors.onBackground
                ),
                shape = AppTheme.shapes.medium
            )
            .background(
                color = colorBackground,
                shape = AppTheme.shapes.medium
            )
            .padding(16.dp)
    )
}