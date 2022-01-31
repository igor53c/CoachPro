package com.ipcoding.coachpro.feature.presentation.select_league

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.select_league.components.Item
import com.ipcoding.coachpro.feature.presentation.util.Screen

@Composable
fun SelectLeagueScreen (
    navController: NavController,
    viewModel: SelectLeagueViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = stringResource(id = R.string.select_league),
            color = MaterialTheme.colors.secondaryVariant,
            style = MaterialTheme.typography.h5
        )
        Spacer(modifier = Modifier.height(16.dp))
        val leagues = stringArrayResource(id = R.array.leagues)
        LazyColumn (verticalArrangement = Arrangement.Center) {
            items(leagues.size) { item ->
                val league = leagues.get(item)
                Item(
                    title = league,
                    modifier = Modifier.clickable {
                        viewModel.saveSelecktedLeague(league)
                        navController.navigate(
                            Screen.SelectClubScreen.route
                        )
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}