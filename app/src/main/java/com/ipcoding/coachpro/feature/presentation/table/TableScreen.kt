package com.ipcoding.coachpro.feature.presentation.table

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.players.components.ButtonBack
import com.ipcoding.coachpro.feature.presentation.select_club.components.CustomButton
import com.ipcoding.coachpro.feature.presentation.table.components.ClubInfo
import com.ipcoding.coachpro.feature.presentation.table.components.OneClub
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun TableScreen(
    navController: NavController,
    viewModel: TableViewModel = hiltViewModel()
) {
    val clubs = viewModel.clubs.value
    val goalsView = remember { mutableStateOf(false) }
    val buttonGoalsText = remember { mutableStateOf("") }
    val text1 = remember { mutableStateOf("") }
    val text2 = remember { mutableStateOf("") }
    val text3 = remember { mutableStateOf("") }
    if(!goalsView.value) {
        buttonGoalsText.value = stringResource(id = R.string.goals)
        text1.value = stringResource(id = R.string.win)
        text2.value = stringResource(id = R.string.draw)
        text3.value = stringResource(id = R.string.lose)
    } else {
        buttonGoalsText.value = stringResource(id = R.string.general)
        text1.value = stringResource(id = R.string.goals_for)
        text2.value = stringResource(id = R.string.goals_against)
        text3.value = stringResource(id = R.string.goal_difference)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = AppTheme.dimensions.spaceMedium,
                end = AppTheme.dimensions.spaceMedium,
                top = AppTheme.dimensions.spaceSmall,
                bottom = AppTheme.dimensions.spaceSmall
            )
    ) {
        Row(
            modifier = Modifier
                .padding(AppTheme.dimensions.spaceSmall)
                .fillMaxWidth()
        ) {
            Text(
                text = viewModel.getStringLeague(),
                color = AppTheme.colors.primary,
                style = AppTheme.typography.body2,
                modifier = Modifier
                    .weight(1f)
            )
            ClubInfo(
                text1 = text1.value,
                text2 = text2.value,
                text3 = text3.value,
                pointsText = stringResource(id = R.string.points)
            )
        }
        LazyColumn (
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f)
        ) {
            items(clubs.size) { item ->
                val club = clubs[item]
                OneClub(
                    club = club,
                    color = viewModel.getColor(club),
                    isShowGoals = goalsView.value
                )
                Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceExtraSmall))
            }
        }
        Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceSmall))
        Row(
            modifier = Modifier
                .height(AppTheme.dimensions.spaceLarge)
                .fillMaxWidth(),
        ) {
            ButtonBack(
                navController = navController,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
            )
            Spacer(modifier = Modifier.width(AppTheme.dimensions.spaceSmall))
            CustomButton(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                onClick = {
                    goalsView.value = !goalsView.value
                }
            ) {
                Text(
                    text = buttonGoalsText.value,
                    color = AppTheme.colors.onPrimary,
                    style = AppTheme.typography.body1
                )
            }
        }
    }

}