package com.ipcoding.coachpro.feature.presentation.main.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.main.MainViewModel
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.AppTheme
import kotlin.math.round

@Composable
fun CentralPart(
    viewModel: MainViewModel,
    navController: NavController,
    colorBackground: Color,
    colorText: Color
) {
    val clubPosition =  viewModel.clubPosition.value
    val clubRating =  viewModel.clubRating.value
    val playersRating =  viewModel.playersRating.value
    val roundNumber = viewModel.roundNumber.value

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = AppTheme.dimensions.spaceMedium)
    ) {
        MainButton(
            rowOne = stringResource(id = R.string.squad),
            rowTwo = round(playersRating).toInt().toString(),
            colorText = colorText,
            background = colorBackground,
            modifier = Modifier.weight(1f),
            onClick = { navController.navigate(Screen.PlayersScreen.route) }
        )

        Spacer(modifier = Modifier.width(AppTheme.dimensions.spaceMedium))

        if (clubPosition == "nullth") viewModel.getClubPositionString()

        MainButton(
            rowOne = viewModel.getStringLeague(),
            rowTwo = clubPosition,
            colorText = colorText,
            background = colorBackground,
            modifier = Modifier.weight(1f),
            onClick = { navController.navigate(Screen.TableScreen.route) }
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = AppTheme.dimensions.spaceMedium)
    ) {
        MainButton(
            rowOne = stringResource(id = R.string.tactics),
            rowTwo = round(clubRating).toInt().toString(),
            colorText = colorText,
            background = colorBackground,
            modifier = Modifier.weight(1f),
            onClick = { navController.navigate(
                Screen.TacticsScreen.route + "?nextIsMatch=${0}")
            }
        )

        Spacer(modifier = Modifier.width(AppTheme.dimensions.spaceMedium))

        MainButton(
            rowOne = stringResource(id = R.string.schedule),
            rowTwo = roundNumber.toString(),
            colorText = colorText,
            background = colorBackground,
            modifier = Modifier.weight(1f),
            onClick = { navController.navigate(Screen.ScheduleScreen.route) }
        )
    }
}