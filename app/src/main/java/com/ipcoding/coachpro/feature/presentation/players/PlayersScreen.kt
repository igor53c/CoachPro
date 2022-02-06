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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.players.components.OnePLayer
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun PlayersScreen (
    navController: NavController,
    viewModel: PlayersViewModel = hiltViewModel()
) {
    val players = viewModel.players.value
    val trainingView = remember { mutableStateOf(false) }
    val buttonTrainingText = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = AppTheme.dimens.spaceMedium,
                end = AppTheme.dimens.spaceMedium,
                top = AppTheme.dimens.spaceSmall,
                bottom = AppTheme.dimens.spaceSmall
            )
    ) {
        Row(
            modifier = Modifier
                .padding(AppTheme.dimens.spaceSmall)
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
                        .width(AppTheme.dimens.spaceExtraLarge)
                )
                Text(
                    text = stringResource(id = R.string.rating),
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(AppTheme.dimens.spaceExtraLarge)
                )
                Text(
                    text = stringResource(id = R.string.age),
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(AppTheme.dimens.spaceLarge)
                )
                Text(
                    text = stringResource(id = R.string.motivation),
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(AppTheme.dimens.spaceExtraLarge)
                )
            } else {
                buttonTrainingText.value = stringResource(id = R.string.general)
                Text(
                    text = stringResource(id = R.string.fitness),
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(AppTheme.dimens.spaceExtraLarge)
                )
                Spacer(modifier = Modifier.width(AppTheme.dimens.spaceSmall))
                Text(
                    text = stringResource(id = R.string.training),
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(AppTheme.dimens.spaceSuperLarge)
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
                Spacer(modifier = Modifier.height(AppTheme.dimens.spaceExtraSmall))
            }
        }
        Spacer(modifier = Modifier.height(AppTheme.dimens.spaceSmall))
        Row(
            modifier = Modifier
                .height(AppTheme.dimens.spaceLarge)
                .fillMaxWidth(),
        ) {
            Button(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                onClick = {
                    navController.navigate(
                        Screen.MainScreen.route
                    )
                }
            ) {
                Text(
                    text = stringResource(id = R.string.back),
                    color = MaterialTheme.colors.onPrimary,
                    style = MaterialTheme.typography.body1,
                )
            }
            Spacer(modifier = Modifier.width(AppTheme.dimens.spaceSmall))
            Button(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
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
}