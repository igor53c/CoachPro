package com.ipcoding.coachpro.feature.presentation.transfers.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.presentation.players.components.PlayerInfo
import com.ipcoding.coachpro.feature.presentation.table.components.CustomText
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun  OneTransferPlayer(
    player: Player,
    color: Color,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(
                start = AppTheme.dimensions.spaceSmall,
                end = AppTheme.dimensions.spaceSmall
            )
            .fillMaxWidth()
            .clickable (onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomText(
            text = player.name,
            textAlign = TextAlign.Start,
            style = AppTheme.typography.body2,
            modifier = Modifier
                .weight(1f)
        )
        CustomText(
            text = player.position,
            style = AppTheme.typography.body2,
            backgroundColor = color,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(AppTheme.dimensions.spaceExtraLarge)
        )
        CustomText(
            text = String.format("%.1f", player.rating),
            style = AppTheme.typography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(AppTheme.dimensions.spaceExtraLarge)
        )
        CustomText(
            text = player.age.toString(),
            style = AppTheme.typography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(AppTheme.dimensions.spaceLarge)
        )
        CustomText(
            text = String.format("%.1f", player.value),
            style = AppTheme.typography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(AppTheme.dimensions.spaceExtraLarge)
        )
    }
}