package com.ipcoding.coachpro.feature.presentation.players.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.presentation.players.PlayersViewModel
import com.ipcoding.coachpro.ui.theme.LocalSpacing

@Composable
fun OnePLayer(
    player: Player,
    color: Color,
    isShowTraining: Boolean,
    playerTraining: Float,
    viewModel: PlayersViewModel
) {
    val spacing = LocalSpacing.current
    val valueTraining = remember { mutableStateOf(playerTraining)}
    Row(
        modifier = Modifier
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = MaterialTheme.colors.primary
                ),
                shape = RoundedCornerShape(corner = CornerSize(spacing.spaceSmall))
            )
            .background(
                color = color,
                shape = RoundedCornerShape(corner = CornerSize(spacing.spaceSmall))
            )
            .padding(spacing.spaceSmall)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            maxLines = 1,
            text = player.name,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.body2,
            modifier = Modifier
                .weight(1f)
        )
        if(!isShowTraining) {
            Text(
                text = player.position,
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(spacing.spaceLarge)
            )
            Text(
                text = player.rating.toString(),
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(spacing.spaceLarge)
            )
            Text(
                text = player.age.toString(),
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(spacing.spaceExtraMedium)
            )
            LinearProgressIndicator(
                modifier = Modifier
                    .width(spacing.spaceLarge),
                backgroundColor = Color.LightGray,
                color = MaterialTheme.colors.primary,
                progress = player.motivation * 0.01f
            )
        } else {
            LinearProgressIndicator(
                modifier = Modifier
                    .width(spacing.spaceLarge),
                backgroundColor = Color.LightGray,
                color = MaterialTheme.colors.primary,
                progress = player.fitness * 0.01f
            )
            Spacer(modifier = Modifier.width(spacing.spaceSmall))
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
                    thumbColor = MaterialTheme.colors.primary,
                    activeTrackColor = MaterialTheme.colors.primary,
                    inactiveTrackColor = Color.LightGray
                ),
                modifier = Modifier
                    .width(spacing.spaceSuperLarge)
                    .height(spacing.spaceSmall)
            )
        }

    }
}