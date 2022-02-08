package com.ipcoding.coachpro.feature.presentation.table.components

import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun ClubInfo(
    text1: String,
    text2: String,
    text3: String,
    pointsText: String
) {
    Text(
        text = text1,
        color = AppTheme.colors.primary,
        style = AppTheme.typography.body2,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .width(AppTheme.dimensions.spaceLarge)
    )
    Text(
        text = text2,
        color = AppTheme.colors.primary,
        style = AppTheme.typography.body2,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .width(AppTheme.dimensions.spaceLarge)
    )
    Text(
        text = text3,
        color = AppTheme.colors.primary,
        style = AppTheme.typography.body2,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .width(AppTheme.dimensions.spaceLarge)
    )
    Text(
        text = pointsText,
        color = AppTheme.colors.primary,
        style = AppTheme.typography.body2,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .width(AppTheme.dimensions.spaceLarge)
    )
}