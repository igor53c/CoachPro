package com.ipcoding.coachpro.feature.presentation.tactics

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.choose_color_jersey.components.Jersey
import com.ipcoding.coachpro.feature.presentation.tactics.components.FootballField
import com.ipcoding.coachpro.feature.presentation.tactics.components.TacticsPicker

@Composable
fun TacticsScreen(
    navController: NavController,
    viewModel: TacticsViewModel = hiltViewModel()
) {
    val colorJersey = viewModel.colorJersey.value
    val colorStripes = viewModel.colorStripes.value
    val tactics = viewModel.tactics.value
    val allTactics = viewModel.allTactics.value
    val maxWidth = remember { mutableStateOf(0.dp) }
    val colorText = remember { mutableStateOf(Color.Black) }
    val colorTextBackground = remember { mutableStateOf(Color.White) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
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
                            .height(height = maxWidth.value / 4)
                    ) {
                        items(tactics[item + 1] as Int) {
                            Box (
                                modifier = Modifier
                                    .size(maxWidth.value / 5)
                            ) {
                                Jersey(
                                    colorJersey = colorJersey,
                                    colorStripes = colorStripes,
                                    colorBorder = MaterialTheme.colors.onBackground,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(8.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}