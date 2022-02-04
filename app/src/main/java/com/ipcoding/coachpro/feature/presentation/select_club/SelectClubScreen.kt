package com.ipcoding.coachpro.feature.presentation.select_club

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
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
import com.ipcoding.coachpro.ui.theme.LocalSpacing

@Composable
fun SelectClubScreen (
    navController: NavController,
    viewModel: SelectClubViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val clubs = viewModel.clubs.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceMedium),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = stringResource(id = R.string.select_club),
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.h5
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        LazyColumn (verticalArrangement = Arrangement.Center) {
            items(clubs.size) { item ->
                val name = clubs[item]
                Item(
                    title = name,
                    modifier = Modifier.clickable {
                        viewModel.saveClubName(name)
                        viewModel.createClubDatabase()
                        navController.navigate(
                            Screen.ChooseColorJerseyScreen.route
                        )
                    }
                )
                Spacer(modifier = Modifier.height(spacing.spaceSmall))
            }
        }
    }
}