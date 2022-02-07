package com.ipcoding.coachpro.feature.presentation.tactics.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.presentation.tactics.TacticsViewModel
import com.ipcoding.coachpro.ui.theme.AppTheme
import com.ipcoding.coachpro.ui.theme.Colors

@Composable
fun TextUnderJersey(
    playerInfo: String,
    viewModel: TacticsViewModel,
    item1: Int,
    item2: Int,
    tactics: List<Any>,
    players: List<Player>
) {
    var colorBackground = AppTheme.colors.background

    if(viewModel.checkPlayerInRightPosition(
            viewModel.getPlayer(players, tactics, item1, item2),
            item1, item2, tactics)
    ) {
        if(item1 != 4) colorBackground = Colors.LightGreen10
    } else colorBackground = Colors.LightRed10
    Text(
        text = playerInfo,
        style = AppTheme.typography.caption,
        color = AppTheme.colors.primary,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(
                color = colorBackground,
                shape = AppTheme.shapes.medium
            )
            .fillMaxWidth()
            .padding(AppTheme.dimensions.spaceSuperSmall)
    )
}