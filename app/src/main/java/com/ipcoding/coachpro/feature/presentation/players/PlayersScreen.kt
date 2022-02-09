package com.ipcoding.coachpro.feature.presentation.players

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.ipcoding.coachpro.feature.presentation.players.components.ButtonBack
import com.ipcoding.coachpro.feature.presentation.players.components.OnePLayer
import com.ipcoding.coachpro.feature.presentation.players.components.PlayerInfo
import com.ipcoding.coachpro.feature.presentation.select_club.components.CustomButton
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
                start = AppTheme.dimensions.spaceMedium,
                end = AppTheme.dimensions.spaceMedium,
                top = AppTheme.dimensions.spaceSmall,
                bottom = AppTheme.dimensions.spaceSmall
            )
    ) {
        Row(
            modifier = Modifier
                .padding(AppTheme.dimensions.spaceSmall)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.name),
                color = AppTheme.colors.primary,
                style = AppTheme.typography.body2,
                modifier = Modifier
                    .weight(1f)
            )
            if(!trainingView.value) {
                buttonTrainingText.value = stringResource(id = R.string.training)
                PlayerInfo(
                    positionText = stringResource(id = R.string.position),
                    ratingText = stringResource(id = R.string.rating),
                    ageText = stringResource(id = R.string.age)
                )
                Text(
                    text = stringResource(id = R.string.motivation),
                    color = AppTheme.colors.primary,
                    style = AppTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(AppTheme.dimensions.spaceExtraLarge)
                )
            } else {
                buttonTrainingText.value = stringResource(id = R.string.general)
                Text(
                    text = stringResource(id = R.string.fitness),
                    color = AppTheme.colors.primary,
                    style = AppTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(AppTheme.dimensions.spaceExtraLarge)
                )
                Spacer(modifier = Modifier.width(AppTheme.dimensions.spaceExtraMedium))
                Text(
                    text = stringResource(id = R.string.training),
                    color = AppTheme.colors.primary,
                    style = AppTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(AppTheme.dimensions.spaceSuperLarge)
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
                Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceExtraSmall))
            }
        }
        Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceSmall))
        Row(
            modifier = Modifier
                .height(AppTheme.dimensions.spaceLarge)
                .fillMaxWidth(),
        ) {
            ButtonBack(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                navController = navController
            )
            Spacer(modifier = Modifier.width(AppTheme.dimensions.spaceSmall))
            CustomButton(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                onClick = {
                    trainingView.value = !trainingView.value
                }
            ) {
                Text(
                    text = buttonTrainingText.value,
                    color = AppTheme.colors.onPrimary,
                    style = AppTheme.typography.body1,
                )
            }
        }
    }
}