package com.ipcoding.coachpro.feature.presentation.select_league

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.select_league.components.Item
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun SelectLeagueScreen (
    navController: NavController,
    viewModel: SelectLeagueViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(AppTheme.dimensions.spaceMedium),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = stringResource(id = R.string.select_league),
            color = AppTheme.colors.primary,
            style = AppTheme.typography.h5
        )
        Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceMedium))
        LazyColumn (verticalArrangement = Arrangement.Center) {
            items(7) { item ->
                val league = stringResource(id = R.string.league)
                val numberLeague = (item + 1).toString()
                Item(
                    title = "$league $numberLeague",
                    modifier = Modifier.clickable {
                        viewModel.saveSelectedLeague(numberLeague)
                        navController.navigate(
                            Screen.SelectClubScreen.route
                        )
                    }
                )
                Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceSmall))
            }
        }
    }
}