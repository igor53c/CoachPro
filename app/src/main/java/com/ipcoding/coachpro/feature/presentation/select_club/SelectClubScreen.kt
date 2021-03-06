package com.ipcoding.coachpro.feature.presentation.select_club

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
import com.ipcoding.coachpro.feature.presentation.select_club.components.CustomButton
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun SelectClubScreen(
    navController: NavController,
    viewModel: SelectClubViewModel = hiltViewModel()
) {
    val clubs = viewModel.clubs.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(AppTheme.dimensions.spaceMedium),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.select_club),
            color = AppTheme.colors.primary,
            style = AppTheme.typography.h5
        )
        Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceMedium))
        LazyColumn(verticalArrangement = Arrangement.Center) {
            items(clubs.size) { item ->
                val name = clubs[item]
                CustomButton(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    onClick = {
                        viewModel.saveClubName(name)
                        viewModel.createClubDatabase()
                        navController.navigate(
                            Screen.ChooseJerseyScreen.route
                        )
                    },
                    contentPadding = PaddingValues(AppTheme.dimensions.spaceMedium)
                ) {
                    Text(
                        text = name,
                        color = AppTheme.colors.onPrimary,
                        style = AppTheme.typography.h6
                    )
                }
                Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceSmall))
            }
        }
    }
}