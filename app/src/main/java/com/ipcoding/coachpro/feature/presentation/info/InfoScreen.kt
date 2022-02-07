package com.ipcoding.coachpro.feature.presentation.info

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.domain.util.WeekType
import com.ipcoding.coachpro.feature.presentation.select_club.components.CustomButton
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun InfoScreen(
    navController: NavController,
    viewModel: InfoViewModel = hiltViewModel()
) {
    val info =  viewModel.info.value

    Column(
        modifier = Modifier
            .padding(
                start = AppTheme.dimensions.spaceMedium,
                end = AppTheme.dimensions.spaceMedium,
                top = AppTheme.dimensions.spaceSmall,
                bottom = AppTheme.dimensions.spaceSmall
            )
            .fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.weight(1f)
        ) {
            info?.let {
                Text(
                    text = it.text,
                    style = AppTheme.typography.h4,
                    color = AppTheme.colors.primary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }
        CustomButton(
            modifier = Modifier
                .height(AppTheme.dimensions.spaceLarge)
                .fillMaxWidth(),
            onClick = {
                info?.let { weekType ->
                    when(weekType) {
                        is WeekType.Schedule ->
                            navController.navigate(Screen.ScheduleScreen.route)
                        is WeekType.Transfers ->
                            navController.navigate(Screen.TransfersScreen.route)
                        is WeekType.Tactics ->
                            navController.navigate(
                                Screen.TacticsScreen.route + "?nextIsMatch=${1}")
                        is WeekType.Else ->
                            navController.navigate(Screen.MainScreen.route)
                    }
                }
            }
        ) {
            Text(
                text = stringResource(id = R.string.confirm),
                style = AppTheme.typography.body1
            )
        }
    }
}