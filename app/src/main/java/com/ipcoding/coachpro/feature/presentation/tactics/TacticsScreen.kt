package com.ipcoding.coachpro.feature.presentation.tactics

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.feature.presentation.players.components.ButtonBack
import com.ipcoding.coachpro.feature.presentation.tactics.components.*
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun TacticsScreen(
    navController: NavController,
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
        )  {
            if(this.maxHeight / this.maxWidth < 1.39)
                maxWidth.value = this.maxHeight / 1.39f else maxWidth.value = this.maxWidth

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
                            if(item1 == 4) players.size - 11 else tactics[item1 + 1] as Int
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
        Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceSmall))
        Row(
            modifier = Modifier
                .height(AppTheme.dimensions.spaceLarge)
                .fillMaxWidth(),
        ) {
            ButtonBack(
                navController = navController,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
            )
            Spacer(modifier = Modifier.width(AppTheme.dimensions.spaceSmall))
            RatingText(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                title = "Rating: ${rating.value}"
            )
        }
    }
}