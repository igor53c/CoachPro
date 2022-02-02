package com.ipcoding.coachpro.feature.presentation.main.table

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
import androidx.navigation.NavController
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.main.table.components.OneClub
import com.ipcoding.coachpro.feature.presentation.util.Screen

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
                start = 16.dp,
                end = 16.dp
            )
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
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
                    .width(30.dp)
            )
            Text(
                text = text2.value,
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(30.dp)
            )
            Text(
                text = text3.value,
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(30.dp)
            )
            Text(
                text = stringResource(id = R.string.points),
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(30.dp)
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
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row (
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
        ){
            Button(
                modifier = Modifier
                    .weight(1f),
                onClick = {
                    navController.navigate(
                        Screen.MainScreen.route
                    )
                }
            ) {
                Text(
                    text = stringResource(id = R.string.back),
                    color = MaterialTheme.colors.onPrimary,
                    style = MaterialTheme.typography.body1
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                modifier = Modifier
                    .weight(1f),
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

}