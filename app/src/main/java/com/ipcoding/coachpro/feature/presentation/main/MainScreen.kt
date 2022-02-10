package com.ipcoding.coachpro.feature.presentation.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.domain.util.WeekType
import com.ipcoding.coachpro.feature.presentation.main.components.*
import com.ipcoding.coachpro.feature.presentation.select_club.components.CustomButton
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val colorText = viewModel.colorText.value
    val colorBackground = viewModel.colorJersey.value
    val info = viewModel.info.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(AppTheme.dimensions.spaceSmall)
    ) {
        Column (
            modifier = Modifier
                .weight(1f)
        ) {
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = AppTheme.dimensions.spaceExtraMedium),
                onClick = {
                    navController.navigate(Screen.SelectLeagueScreen.route)
                }
            ) {
                Text(
                    text = "CoachPro",
                    style = AppTheme.typography.h5,
                    color = AppTheme.colors.background
                )
            }

            DateRow(viewModel = viewModel)

            ClubName(
                name = viewModel.clubName.value,
                colorBackground = colorBackground,
                colorText = colorText
            )

            CentralPart(
                viewModel = viewModel,
                navController = navController,
                colorBackground = colorBackground,
                colorText = colorText
            )
        }
        CustomButton(
            modifier = Modifier
                .height(AppTheme.dimensions.spaceLarge)
                .fillMaxWidth(),
            onClick = {
                viewModel.saveWeekYear()
                navController.navigate(Screen.InfoScreen.route)
            }
        ) {
            info?.let { weekType ->
                when(weekType) {
                    is WeekType.Schedule ->
                        weekType.text = stringResource(id = R.string.next_week)
                    is WeekType.Transfers ->
                        weekType.text = stringResource(id = R.string.transfers)
                    is WeekType.Tactics ->
                        weekType.text = stringResource(id = R.string.match)
                    is WeekType.Else ->
                        weekType.text = stringResource(id = R.string.next_week)
                }
                Text(
                    text = weekType.text,
                    style = AppTheme.typography.body1
                )
            }
        }
    }
}