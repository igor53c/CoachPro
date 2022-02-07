package com.ipcoding.coachpro.feature.presentation.players.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.presentation.players.PlayersViewModel
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
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = AppTheme.colors.primary
                ),
                shape = AppTheme.shapes.medium
            )
            .background(
                color = color,
                shape = AppTheme.shapes.medium
            )
            .padding(AppTheme.dimensions.spaceSmall)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            maxLines = 1,
            text = player.name,
            color = AppTheme.colors.primary,
            style = AppTheme.typography.body2,
            modifier = Modifier
                .weight(1f)
        )
        if(!isShowTraining) {
           PlayerInfo(
               positionText = player.position,
               ratingText = player.rating.toString(),
               ageText = player.age.toString()
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
            Spacer(modifier = Modifier.width(AppTheme.dimensions.spaceSmall))
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