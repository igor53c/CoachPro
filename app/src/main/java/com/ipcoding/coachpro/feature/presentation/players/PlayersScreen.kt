package com.ipcoding.coachpro.feature.presentation.players

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.players.components.OnePLayer
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.LocalSpacing

@Composable
fun PlayersScreen (
    navController: NavController,
    viewModel: PlayersViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val players = viewModel.state.value
    val trainingView = remember { mutableStateOf(false) }
    val buttonTrainingText = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = spacing.spaceMedium,
                end = spacing.spaceMedium,
                top = spacing.spaceSmall,
                bottom = spacing.spaceSmall
            )
    ) {
        Row(
            modifier = Modifier
                .padding(spacing.spaceSmall)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.name),
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .weight(1f)
            )
            if(!trainingView.value) {
                buttonTrainingText.value = stringResource(id = R.string.training)
                Text(
                    text = stringResource(id = R.string.position),
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(spacing.spaceLarge)
                )
                Text(
                    text = stringResource(id = R.string.rating),
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(spacing.spaceLarge)
                )
                Text(
                    text = stringResource(id = R.string.age),
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(spacing.spaceExtraMedium)
                )
                Text(
                    text = stringResource(id = R.string.motivation),
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(spacing.spaceLarge)
                )
            } else {
                buttonTrainingText.value = stringResource(id = R.string.general)
                Text(
                    text = stringResource(id = R.string.fitness),
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(spacing.spaceLarge)
                )
                Spacer(modifier = Modifier.width(spacing.spaceSmall))
                Text(
                    text = stringResource(id = R.string.training),
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(spacing.spaceSuperLarge)
                )
            }

        }
        LazyColumn (
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f)
        ) {
            items(players.size) { item ->
                val player = players[item]
                OnePLayer(
                    player = player,
                    color = viewModel.getColor(player.position),
                    isShowTraining = trainingView.value,
                    playerTraining = player.training.toFloat(),
                    viewModel = viewModel
                )
                Spacer(modifier = Modifier.height(spacing.spaceExtraSmall))
            }
        }
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        Button(
            modifier = Modifier
                .height(spacing.spaceLarge)
                .fillMaxWidth(),
            onClick = {
                trainingView.value = !trainingView.value
            }
        ) {
            Text(
                text = buttonTrainingText.value,
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.body1,
            )
        }
    }
}