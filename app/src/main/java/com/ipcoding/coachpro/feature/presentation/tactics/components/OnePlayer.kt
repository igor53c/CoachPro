package com.ipcoding.coachpro.feature.presentation.tactics.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.presentation.choose_jersey.components.Jersey
import com.ipcoding.coachpro.feature.presentation.tactics.TacticsViewModel
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun OnePlayer(
    item1: Int,
    item2: Int,
    viewModel: TacticsViewModel,
    players: List<Player>,
    tactics: List<Any>,
    maxWidth: Dp
) {
    val colorJersey = viewModel.colorJersey.value
    val colorStripes = viewModel.colorStripes.value
    val playerInfo = remember { mutableStateOf("") }
    val previouslyClickedInfo  = viewModel.previouslyClickedInfo.value
    var borderColor = Color.Transparent
    val colorPrimary = AppTheme.colors.primary
    if(previouslyClickedInfo.item1 == item1
        &&  previouslyClickedInfo.item2 == item2) {
        borderColor = previouslyClickedInfo.color
    }
    Column (
        modifier = Modifier
            .clickable {
                previouslyClickedInfo.newPlayer =
                    viewModel.getPlayer(players, tactics, item1, item2)
                viewModel.replaceTwoPlayers(
                    previouslyClickedInfo = previouslyClickedInfo,
                    item1 = item1,
                    item2 = item2,
                    color = colorPrimary
                )
            }
            .width(maxWidth / 5)
            .border(
                width = AppTheme.dimensions.spaceExtraSmall,
                color = borderColor,
                shape = AppTheme.shapes.medium
            )
            .padding(AppTheme.dimensions.spaceSuperSmall)
    ) {
        Box(
            modifier = Modifier
                .height(maxWidth / 5f)
        ) {
            Jersey(
                colorJersey = colorJersey,
                colorStripes = colorStripes,
                colorBorder = AppTheme.colors.onBackground,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(AppTheme.dimensions.spaceExtraSmall)
            )
        }

        Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceSuperSmall))

        playerInfo.value = viewModel
            .getPlayerInfo(players, tactics, item1, item2)
        TextUnderJersey(
            playerInfo = playerInfo.value,
            viewModel = viewModel,
            item1 = item1,
            item2 = item2,
            tactics = tactics,
            players = players
        )
    }
}