package com.ipcoding.coachpro.feature.presentation.table

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.select_club.components.CustomButton
import com.ipcoding.coachpro.feature.presentation.table.components.ClubInfo
import com.ipcoding.coachpro.feature.presentation.table.components.CustomText
import com.ipcoding.coachpro.feature.presentation.table.components.OneClub
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun TableScreen(
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
            .padding(top = AppTheme.dimensions.spaceSmall),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            CustomText(
                text = "#",
                style = AppTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = AppTheme.dimensions.spaceSmall)
                    .width(AppTheme.dimensions.spaceExtraMedium)
            )
            CustomText(
                text = viewModel.getStringLeague(),
                style = AppTheme.typography.body2,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(start = AppTheme.dimensions.spaceExtraSmall)
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
            modifier = Modifier.weight(1f)
        ) {
            items(clubs.size) { item ->
                if(item == 0) {
                    Divider(
                        color = AppTheme.colors.primary,
                        thickness = AppTheme.dimensions.spaceSuperSmall
                    )
                }
                OneClub(
                    clubName = viewModel.getClubName(),
                    club = clubs[item],
                    color = viewModel.getColorOfClubInTable(item + 1),
                    isShowGoals = goalsView.value
                )
                Divider(
                    color = AppTheme.colors.primary,
                    thickness = AppTheme.dimensions.spaceSuperSmall
                )
            }
        }
        Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceSmall))

        CustomButton(
            modifier = Modifier
                .height(AppTheme.dimensions.spaceLarge)
                .fillMaxWidth(),
            onClick = {
                goalsView.value = !goalsView.value
            },
            shape = AppTheme.customShapes.rectangleShape
        ) {
            Text(
                text = buttonGoalsText.value,
                color = AppTheme.colors.onPrimary,
                style = AppTheme.typography.body1
            )
        }
    }
}