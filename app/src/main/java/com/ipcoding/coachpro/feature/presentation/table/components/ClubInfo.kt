package com.ipcoding.coachpro.feature.presentation.table.components

import androidx.compose.foundation.layout.width
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
    CustomText(
        text = text1,
        style = AppTheme.typography.body2,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .width(AppTheme.dimensions.spaceLarge)
    )
    CustomText(
        text = text2,
        style = AppTheme.typography.body2,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .width(AppTheme.dimensions.spaceLarge)
    )
    CustomText(
        text = text3,
        style = AppTheme.typography.body2,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .width(AppTheme.dimensions.spaceLarge)
    )
    CustomText(
        text = pointsText,
        style = AppTheme.typography.body2,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .width(AppTheme.dimensions.spaceLarge)
    )
}