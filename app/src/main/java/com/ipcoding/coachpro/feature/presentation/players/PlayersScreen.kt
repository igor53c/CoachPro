package com.ipcoding.coachpro.feature.presentation.players

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.core.util.TestTags
import com.ipcoding.coachpro.feature.presentation.players.components.OnePLayer
import com.ipcoding.coachpro.feature.presentation.select_club.components.CustomButton
import com.ipcoding.coachpro.feature.presentation.table.components.CustomText
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun PlayersScreen(
    viewModel: PlayersViewModel = hiltViewModel()
) {
    val players = viewModel.players.value
    val trainingView = remember { mutableStateOf(false) }
    val buttonTrainingText = remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = AppTheme.dimensions.spaceSmall),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = AppTheme.dimensions.spaceSmall,
                    end = AppTheme.dimensions.spaceSmall
                )
                .fillMaxWidth()
        ) {
            CustomText(
                text = stringResource(id = R.string.name),
                textAlign = TextAlign.Start,
                style = AppTheme.typography.body2,
                modifier = Modifier
                    .weight(1f)
            )
            if (!trainingView.value) {
                buttonTrainingText.value = stringResource(id = R.string.training)
                CustomText(
                    text = stringResource(id = R.string.pos),
                    style = AppTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(AppTheme.dimensions.spaceExtraLarge)
                )
                CustomText(
                    text = stringResource(id = R.string.rating),
                    style = AppTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(AppTheme.dimensions.spaceExtraLarge)
                )
                CustomText(
                    text = stringResource(id = R.string.age),
                    style = AppTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(AppTheme.dimensions.spaceLarge)
                )
                CustomText(
                    text = stringResource(id = R.string.motivation),
                    style = AppTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(AppTheme.dimensions.spaceExtraLarge)
                )
            } else {
                buttonTrainingText.value = stringResource(id = R.string.general)
                CustomText(
                    text = stringResource(id = R.string.fitness),
                    style = AppTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(AppTheme.dimensions.spaceExtraLarge)
                )
                Spacer(modifier = Modifier.width(AppTheme.dimensions.spaceExtraMedium))
                CustomText(
                    text = stringResource(id = R.string.training),
                    style = AppTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(AppTheme.dimensions.spaceSuperLarge)
                        .testTag(TestTags.TRAINING_TEXT)
                )
            }

        }
        Divider(
            color = AppTheme.colors.primary,
            thickness = AppTheme.dimensions.spaceSuperSmall
        )
        LazyColumn(
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
                Divider(
                    color = AppTheme.colors.primary,
                    thickness = AppTheme.dimensions.spaceSuperSmall
                )
            }
        }
        Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceSmall))

        CustomButton(
            modifier = Modifier
                .height(AppTheme.dimensions.spaceLarge)
                .fillMaxWidth()
                .testTag(TestTags.TRAINING_BUTTON),
            onClick = {
                trainingView.value = !trainingView.value
            },
            shape = AppTheme.customShapes.rectangleShape
        ) {
            Text(
                text = buttonTrainingText.value,
                color = AppTheme.colors.onPrimary,
                style = AppTheme.typography.body1,
            )
        }
    }
}