package com.ipcoding.coachpro.feature.presentation.schedule.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.coachpro.feature.domain.model.Match
import com.ipcoding.coachpro.ui.theme.AppTheme
import com.ipcoding.coachpro.ui.theme.Colors

@Composable
fun OneMatch(
    match: Match,
    modifier: Modifier = Modifier,
    clubName: String
) {
    val colorBackground  = remember { mutableStateOf(Color.Transparent) }

    if(clubName == match.host || clubName == match.guest)
        colorBackground.value = Colors.LightGray10 else
        colorBackground.value = AppTheme.colors.background
    Row(
        modifier = modifier
            .background(
                color = colorBackground.value,
                shape = AppTheme.shapes.medium
            )
            .padding(
                top = AppTheme.dimensions.spaceExtraSmall,
                bottom = AppTheme.dimensions.spaceExtraSmall
            )
            .fillMaxWidth()
    ) {
        Text(
            text = match.host,
            color = AppTheme.colors.primary,
            style = AppTheme.typography.body2,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.End
        )
        Spacer(modifier = Modifier.width(AppTheme.dimensions.spaceExtraSmall))
        Text(
            text = match.goalsHost.toString(),
            color = AppTheme.colors.primary,
            style = AppTheme.typography.body2,
            modifier = Modifier.width(AppTheme.dimensions.spaceMedium),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.width(AppTheme.dimensions.spaceExtraSmall))
        Text(
            text = match.goalsGuest.toString(),
            color = AppTheme.colors.primary,
            style = AppTheme.typography.body2,
            modifier = Modifier.width(AppTheme.dimensions.spaceMedium),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.width(AppTheme.dimensions.spaceExtraSmall))
        Text(
            text = match.guest,
            color = AppTheme.colors.primary,
            style = AppTheme.typography.body2,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Start
        )
    }
}