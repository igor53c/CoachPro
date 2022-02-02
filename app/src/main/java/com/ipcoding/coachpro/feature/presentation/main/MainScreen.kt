package com.ipcoding.coachpro.feature.presentation.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.feature.presentation.main.components.ClubName
import com.ipcoding.coachpro.feature.presentation.main.components.MainButton
import com.ipcoding.coachpro.feature.presentation.util.Screen

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val colorText = viewModel.colorStripes.value
    val colorBackground = viewModel.colorJersey.value
    Column {
        ClubName(
            name = viewModel.clubName.value,
            colorBackground = colorBackground,
            colorText = colorText
        )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        navController.navigate(
                            Screen.PlayersScreen.route
                        )
                    }
            ) {
                MainButton(
                    rowOne = "SQUAD",
                    rowTwo = "35",
                    colorText = colorText,
                    background = colorBackground
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clickable {  }
            ) {
                MainButton(
                    rowOne = "TRAINING",
                    rowTwo = "38",
                    colorText = colorText,
                    background = colorBackground
                )
            }
        }
    }
}