package com.ipcoding.coachpro.feature.presentation.tactics

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.feature.presentation.choose_color_jersey.components.Jersey
import com.ipcoding.coachpro.feature.presentation.tactics.components.FootballField

@Composable
fun TacticsScreen(
    navController: NavController,
    viewModel: TacticsViewModel = hiltViewModel()
) {
    val colorJersey = viewModel.colorJersey.value
    val colorStripes = viewModel.colorStripes.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Box() {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
            ) {
                Jersey(
                    colorJersey = colorJersey,
                    colorStripes = colorStripes,
                    colorBorder = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .fillMaxWidth(0.2f)
                )
            }
            Row(

            ) {

            }
            Row(

            ) {

            }
            Row(

            ) {

            }
            FootballField(
                colorLinie = MaterialTheme.colors.onBackground
            )
        }
    }
}