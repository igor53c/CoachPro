package com.ipcoding.coachpro.feature.presentation.schedule

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.schedule.components.OneMatch
import com.ipcoding.coachpro.feature.presentation.select_league.components.Item
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun ScheduleScreen(
    navController: NavController,
    viewModel: ScheduleViewModel = hiltViewModel()
) {
    val maxWidth = remember { mutableStateOf(0.dp) }
    val matches = viewModel.matches.value
    val clubName = viewModel.clubName.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = AppTheme.dimens.spaceMedium,
                end = AppTheme.dimens.spaceMedium,
                top = AppTheme.dimens.spaceSmall,
                bottom = AppTheme.dimens.spaceSmall
            )
    ) {
        Item(title = viewModel.getStringLeague())
        Spacer(modifier = Modifier.height(AppTheme.dimens.spaceMedium))
        BoxWithConstraints(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = AppTheme.dimens.spaceSmall)
        ) {
            maxWidth.value = this.maxWidth

            LazyRow(
                verticalAlignment = Alignment.Top,
                modifier = Modifier
            ) {
                items(38) { item1 ->
                    Column(
                        modifier = Modifier
                            .width(maxWidth.value)
                    ) {
                        Item(
                            title = "Round ${item1 + 1}",
                            colorText = MaterialTheme.colors.background,
                            colorBackground = MaterialTheme.colors.primary,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(AppTheme.dimens.spaceSmall))
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    top = AppTheme.dimens.spaceSmall,
                                    bottom = AppTheme.dimens.spaceSmall
                                )
                        ) {
                            items(10) { item2 ->
                                if(matches.isNotEmpty()) {
                                    val match = matches[item1 * 10 + item2]
                                    OneMatch(
                                        match = match,
                                        clubName = clubName
                                    )
                                }
                            }
                        }
                    }
                    if(item1 != 37)
                        Spacer(modifier = Modifier.width(AppTheme.dimens.spaceExtraMedium))
                }
            }
        }
        Button(
            modifier = Modifier
                .height(AppTheme.dimens.spaceLarge)
                .fillMaxWidth(),
            onClick = {
                navController.navigate(
                    Screen.MainScreen.route
                )
            }
        ) {
            Text(
                text = stringResource(id = R.string.back),
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.body1,
            )
        }
    }
}