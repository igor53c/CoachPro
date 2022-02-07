package com.ipcoding.coachpro.feature.presentation.players.components

import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun PlayerInfo(
    positionText: String,
    ratingText: String,
    ageText: String
) {
    Text(
        text = positionText,
        color = AppTheme.colors.primary,
        style = AppTheme.typography.body2,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .width(AppTheme.dimensions.spaceExtraLarge)
    )
    Text(
        text = ratingText,
        color = AppTheme.colors.primary,
        style = AppTheme.typography.body2,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .width(AppTheme.dimensions.spaceExtraLarge)
    )
    Text(
        text = ageText,
        color = AppTheme.colors.primary,
        style = AppTheme.typography.body2,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .width(AppTheme.dimensions.spaceLarge)
    )
}