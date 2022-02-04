package com.ipcoding.coachpro.feature.presentation.tactics

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.ipcoding.coachpro.feature.presentation.choose_color_jersey.components.Jersey
import com.ipcoding.coachpro.feature.presentation.tactics.components.FootballField
import com.ipcoding.coachpro.feature.presentation.tactics.components.TacticsPicker
import com.ipcoding.coachpro.ui.theme.LocalSpacing

@Composable
fun TacticsScreen(
    viewModel: TacticsViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val players = viewModel.state.value
    val colorJersey = viewModel.colorJersey.value
    val colorStripes = viewModel.colorStripes.value
    val tactics = viewModel.tactics.value
    val allTactics = viewModel.allTactics.value
    val maxWidth = remember { mutableStateOf(spacing.default) }
    val colorText = remember { mutableStateOf(Color.Black) }
    val colorTextBackground = remember { mutableStateOf(Color.White) }
    val playerInfo = remember { mutableStateOf("") }
    val previouslyClickedInfo  = viewModel.previouslyClickedInfo.value

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
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
        )  {
            maxWidth.value = this.maxWidth

            FootballField(
                colorLinie = MaterialTheme.colors.onBackground
            )
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(5) { item1 ->
                    LazyRow(
                        modifier = Modifier
                            .height(height = maxWidth.value / 3.6f)
                    ) {
                        val numberItem2 =
                            if(item1 == 4) players.size - 11 else tactics[item1 + 1] as Int
                        items(numberItem2) { item2 ->
                            var borderColor = Color.Transparent
                            val colorPrimary = MaterialTheme.colors.primary
                            if(previouslyClickedInfo.item1 == item1
                                &&  previouslyClickedInfo.item2 == item2) {
                                borderColor = previouslyClickedInfo.color
                            }
                            Column (
                                modifier = Modifier
                                    .clickable {
                                        previouslyClickedInfo.newPlayer =
                                            viewModel.getPlayer(players, tactics, item1, item2)
                                        viewModel.replaceTwoPlayers(
                                            previouslyClickedInfo = previouslyClickedInfo,
                                            item1 = item1,
                                            item2 = item2,
                                            color = colorPrimary
                                        )
                                    }
                                    .width(maxWidth.value / 5)
                                    .border(
                                        width = spacing.spaceExtraSmall,
                                        color = borderColor,
                                        shape = RoundedCornerShape(spacing.spaceSmall)
                                    )
                            ) {
                                Box(
                                    modifier = Modifier
                                        .height(maxWidth.value / 5f)
                                ) {
                                    Jersey(
                                        colorJersey = colorJersey,
                                        colorStripes = colorStripes,
                                        colorBorder = MaterialTheme.colors.onBackground,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(spacing.spaceSmall)
                                    )
                                }

                                playerInfo.value =
                                    viewModel.getPlayerInfo(players, tactics, item1, item2)

                                Spacer(modifier = Modifier.height(spacing.spaceExtraSmall))
                                Text(
                                    text = playerInfo.value,
                                    style = MaterialTheme.typography.caption,
                                    color = MaterialTheme.colors.primary,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .padding(bottom = spacing.spaceSmall)
                                        .fillMaxWidth()
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}