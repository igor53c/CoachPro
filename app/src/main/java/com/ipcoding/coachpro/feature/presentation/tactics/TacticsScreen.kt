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
import androidx.hilt.navigation.compose.hiltViewModel
import com.ipcoding.coachpro.feature.presentation.tactics.components.*
import com.ipcoding.coachpro.ui.theme.LocalSpacing

@Composable
fun TacticsScreen(
    viewModel: TacticsViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val players = viewModel.players.value
    val tactics = viewModel.tactics.value
    val allTactics = viewModel.allTactics.value
    val maxWidth = remember { mutableStateOf(spacing.default) }
    val colorText = remember { mutableStateOf(Color.Black) }
    val rating = remember { mutableStateOf("") }
    val colorTextBackground = remember { mutableStateOf(Color.White) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceSmall)
    ) {
        TacticsPicker(
            allTactics = allTactics,
            colorText = colorText,
            colorTextBackground = colorTextBackground,
            tactics = tactics,
            viewModel = viewModel
        )
        rating.value = String.format("%.1f", viewModel.getRating(players, tactics))

        RatingText(title = "Rating:    ${rating.value}")

        Spacer(modifier = Modifier.height(spacing.spaceSmall))

        BoxWithConstraints(modifier = Modifier.fillMaxSize())  {
            maxWidth.value = this.maxWidth

            FootballField(colorLine = MaterialTheme.colors.onBackground)
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
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
    }
}