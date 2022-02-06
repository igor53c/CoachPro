package com.ipcoding.coachpro.feature.presentation.tactics.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.coachpro.core.util.Colors
import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.presentation.tactics.TacticsViewModel
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun PlayerInfo(
    playerInfo: String,
    viewModel: TacticsViewModel,
    item1: Int,
    item2: Int,
    tactics: List<Any>,
    players: List<Player>
) {

    var colorBackground = MaterialTheme.colors.background

    if(viewModel.checkPlayerInRightPosition(
            viewModel.getPlayer(players, tactics, item1, item2),
            item1, item2, tactics)
    ) {
        if(item1 != 4) colorBackground = Colors.LightGreen10
    } else colorBackground = Colors.LightRed10
    Text(
        text = playerInfo,
        style = MaterialTheme.typography.caption,
        color = MaterialTheme.colors.primary,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(
                color = colorBackground,
                shape = RoundedCornerShape(AppTheme.dimens.spaceSmall)
            )
            .fillMaxWidth()
            .padding(AppTheme.dimens.spaceExtraSmall)
    )
}