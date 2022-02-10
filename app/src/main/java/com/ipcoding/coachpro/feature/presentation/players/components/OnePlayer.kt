package com.ipcoding.coachpro.feature.presentation.players.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.presentation.players.PlayersViewModel
import com.ipcoding.coachpro.feature.presentation.table.components.CustomText
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun OnePLayer(
    player: Player,
    color: Color,
    isShowTraining: Boolean,
    playerTraining: Float,
    viewModel: PlayersViewModel
) {
    val valueTraining = remember { mutableStateOf(playerTraining)}
    Row(
        modifier = Modifier
            .padding(
                start = AppTheme.dimensions.spaceSmall,
                end = AppTheme.dimensions.spaceSmall
            )
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomText(
            text = player.name,
            textAlign = TextAlign.Start,
            style = AppTheme.typography.body2,
            modifier = Modifier
                .weight(1f)
        )
        if(!isShowTraining) {
           PlayerInfo(
               positionText = player.position,
               ratingText = player.rating.toString(),
               ageText = player.age.toString(),
               positionBackgroundColor = color
           )
            LinearProgressIndicator(
                modifier = Modifier
                    .width(AppTheme.dimensions.spaceExtraLarge),
                backgroundColor = Color.LightGray,
                color = AppTheme.colors.primary,
                progress = player.motivation * 0.01f
            )
        } else {
            LinearProgressIndicator(
                modifier = Modifier
                    .width(AppTheme.dimensions.spaceExtraLarge),
                backgroundColor = Color.LightGray,
                color = AppTheme.colors.primary,
                progress = player.fitness * 0.01f
            )
            Spacer(modifier = Modifier.width(AppTheme.dimensions.spaceExtraMedium))
            Slider(
                value = valueTraining.value,
                onValueChange = {
                    valueTraining.value = it
                    },
                valueRange = 0f..5f,
                onValueChangeFinished = {
                    player.training = valueTraining.value.toInt()
                    viewModel.updatePlayer(player)
                },
                steps = 4,
                colors = SliderDefaults.colors(
                    thumbColor = AppTheme.colors.primary,
                    activeTrackColor = AppTheme.colors.primary,
                    inactiveTrackColor = Color.LightGray
                ),
                modifier = Modifier
                    .width(AppTheme.dimensions.spaceSuperLarge)
                    .height(AppTheme.dimensions.spaceSmall)
            )
        }
    }
}