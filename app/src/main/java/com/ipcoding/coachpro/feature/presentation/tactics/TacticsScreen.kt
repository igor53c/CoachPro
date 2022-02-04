package com.ipcoding.coachpro.feature.presentation.tactics

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.choose_color_jersey.components.Jersey
import com.ipcoding.coachpro.feature.presentation.tactics.components.FootballField
import com.ipcoding.coachpro.feature.presentation.tactics.components.TacticsPicker
import com.ipcoding.coachpro.ui.theme.LocalSpacing

@Composable
fun TacticsScreen(
    navController: NavController,
    viewModel: TacticsViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val players = viewModel.players.value
    val colorJersey = viewModel.colorJersey.value
    val colorStripes = viewModel.colorStripes.value
    val tactics = viewModel.tactics.value
    val allTactics = viewModel.allTactics.value
    val maxWidth = remember { mutableStateOf(spacing.default) }
    val colorText = remember { mutableStateOf(Color.Black) }
    val colorTextBackground = remember { mutableStateOf(Color.White) }
    val numberPlayer = remember { mutableStateOf(-1) }
    val itemRemember = remember { mutableStateOf(-1) }
    val item2Remember = remember { mutableStateOf(-1) }
    val playerInfo = remember { mutableStateOf("") }

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
            modifier = Modifier.fillMaxSize()
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
                items(4) { item ->
                    LazyRow(
                        modifier = Modifier
                            .height(height = maxWidth.value / 4f)
                    ) {
                        items(tactics[item + 1] as Int) { item2 ->
                            Column (
                                modifier = Modifier
                                    .width(maxWidth.value / 5)
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
                                if(
                                    players.size > 0 &&
                                    (item != itemRemember.value || item2 != item2Remember.value)
                                )  {
                                    if(item == 0 && item2 == 0)
                                        numberPlayer.value = 0 else numberPlayer.value++
                                    itemRemember.value = item
                                    item2Remember.value = item2
                                    playerInfo.value = players[numberPlayer.value].position +
                                            " " +  players[numberPlayer.value].rating.toString()
                                }
                                Spacer(modifier = Modifier.height(spacing.spaceExtraSmall))
                                Text(
                                    text = playerInfo.value,
                                    style = MaterialTheme.typography.caption,
                                    color = MaterialTheme.colors.primary,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
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