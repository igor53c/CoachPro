package com.ipcoding.coachpro.feature.presentation.tactics

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.select_club.components.CustomButton
import com.ipcoding.coachpro.feature.presentation.tactics.components.FootballField
import com.ipcoding.coachpro.feature.presentation.tactics.components.OnePlayer
import com.ipcoding.coachpro.feature.presentation.tactics.components.RatingText
import com.ipcoding.coachpro.feature.presentation.tactics.components.TacticsPicker
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun TacticsScreen(
    navController: NavController,
    nextIsMatch: String,
    viewModel: TacticsViewModel = hiltViewModel()
) {
    val players = viewModel.players.value
    val tactics = viewModel.tactics.value
    val allTactics = viewModel.allTactics.value
    val maxWidth = remember { mutableStateOf(0.dp) }
    val colorText = remember { mutableStateOf(Color.Black) }
    val rating = remember { mutableStateOf("") }
    val colorTextBackground = remember { mutableStateOf(Color.White) }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(AppTheme.dimensions.spaceSmall)
        ) {
            TacticsPicker(
                allTactics = allTactics,
                colorText = colorText,
                colorTextBackground = colorTextBackground,
                tactics = tactics,
                viewModel = viewModel
            )
            Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceSmall))

            rating.value =
                String.format("%.1f", viewModel.calculatingFirstTeamRating(players, tactics))

            BoxWithConstraints(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = AppTheme.dimensions.spaceSmall),
                contentAlignment = Alignment.TopCenter
            ) {
                if (this.maxHeight / this.maxWidth < 1.395)
                    maxWidth.value = this.maxHeight / 1.395f else maxWidth.value = this.maxWidth

                FootballField(
                    colorLine = MaterialTheme.colors.onBackground,
                    width = maxWidth.value
                )
                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                ) {
                    items(5) { item1 ->
                        LazyRow(modifier = Modifier.height(height = maxWidth.value / 3.6f)) {
                            val numberItem2 =
                                if (item1 == 4) players.size - 11 else tactics[item1 + 1] as Int
                            items(numberItem2) { item2 ->

                                OnePlayer(
                                    item1 = item1,
                                    item2 = item2,
                                    viewModel = viewModel,
                                    players = players,
                                    tactics = tactics,
                                    maxWidth = maxWidth.value
                                )
                            }
                        }
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .height(AppTheme.dimensions.spaceLarge)
                .fillMaxWidth(),
        ) {
            RatingText(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                title = "Rating: ${rating.value}"
            )
            if (nextIsMatch == "yes") {
                CustomButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    onClick = {
                        viewModel.increaseRound()
                        viewModel.saveNextDestinationScreen()
                        navController.navigate(Screen.ResultScreen.route)
                    },
                    shape = AppTheme.customShapes.rectangleShape
                ) {
                    Text(
                        text = stringResource(id = R.string.confirm),
                        style = AppTheme.typography.body1
                    )
                }
            }
        }
    }
}