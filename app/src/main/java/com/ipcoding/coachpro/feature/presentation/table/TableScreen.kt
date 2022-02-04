package com.ipcoding.coachpro.feature.presentation.table

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.table.components.OneClub
import com.ipcoding.coachpro.ui.theme.LocalSpacing

@Composable
fun TableScreen(
    viewModel: TableViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
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
                start = spacing.spaceMedium,
                end = 16.dp,
                top = 8.dp,
                bottom = 8.dp
            )
    ) {
        Row(
            modifier = Modifier
                .padding(spacing.spaceSmall)
                .fillMaxWidth()
        ) {
            Text(
                text = viewModel.getStringLeague(),
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .weight(1f)
            )
            Text(
                text = text1.value,
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(spacing.spaceExtraMedium)
            )
            Text(
                text = text2.value,
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(spacing.spaceExtraMedium)
            )
            Text(
                text = text3.value,
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(spacing.spaceExtraMedium)
            )
            Text(
                text = stringResource(id = R.string.points),
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(spacing.spaceExtraMedium)
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
                Spacer(modifier = Modifier.height(spacing.spaceExtraSmall))
            }
        }
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        Button(
            modifier = Modifier
                .height(spacing.spaceLarge)
                .fillMaxWidth(),
            onClick = {
                goalsView.value = !goalsView.value
            }
        ) {
            Text(
                text = buttonGoalsText.value,
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.body1
            )
        }
    }

}