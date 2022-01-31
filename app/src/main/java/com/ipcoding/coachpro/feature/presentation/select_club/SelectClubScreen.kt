package com.ipcoding.coachpro.feature.presentation.select_club

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun SelectClubScreen (
    navController: NavController,
    viewModel: SelectClubViewModel = hiltViewModel()
) {
    Text(text = viewModel.league.value)
}