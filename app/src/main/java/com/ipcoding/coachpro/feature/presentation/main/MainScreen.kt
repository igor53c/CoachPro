package com.ipcoding.coachpro.feature.presentation.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.feature.presentation.main.components.ClubName
import com.ipcoding.coachpro.feature.presentation.main.components.MainButton
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.LocalSpacing

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val colorText = viewModel.colorStripes.value
    val colorBackground = viewModel.colorJersey.value
    val clubPosition =  viewModel.clubPosition.value
    Column {
        ClubName(
            name = viewModel.clubName.value,
            colorBackground = colorBackground,
            colorText = colorText
        )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(spacing.spaceMedium)
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
                    .clickable {
                        navController.navigate(
                            Screen.TableScreen.route
                        )
                    }
            ) {
                if(clubPosition == "nullth") viewModel.getClubPositionString()
                MainButton(
                    rowOne = viewModel.getStringLeague(),
                    rowTwo = clubPosition,
                    colorText = colorText,
                    background = colorBackground
                )
            }
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(spacing.spaceMedium)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        navController.navigate(
                            Screen.TacticsScreen.route
                        )
                    }
            ) {
                MainButton(
                    rowOne = "Tactics",
                    rowTwo = "38",
                    colorText = colorText,
                    background = colorBackground
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                    }
            ) {
                MainButton(
                    rowOne = "Schedule",
                    rowTwo = "39",
                    colorText = colorText,
                    background = colorBackground
                )
            }
        }
    }
}