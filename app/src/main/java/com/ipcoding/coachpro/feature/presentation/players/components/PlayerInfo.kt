package com.ipcoding.coachpro.feature.presentation.players.components

import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.coachpro.feature.presentation.table.components.CustomText
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun PlayerInfo(
    positionText: String,
    ratingText: String,
    ageText: String,
    positionBackgroundColor: Color
) {
    CustomText(
        text = positionText,
        style = AppTheme.typography.body2,
        backgroundColor = positionBackgroundColor,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .width(AppTheme.dimensions.spaceExtraLarge)
    )
    CustomText(
        text = ratingText,
        style = AppTheme.typography.body2,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .width(AppTheme.dimensions.spaceExtraLarge)
    )
    CustomText(
        text = ageText,
        style = AppTheme.typography.body2,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .width(AppTheme.dimensions.spaceLarge)
    )
}