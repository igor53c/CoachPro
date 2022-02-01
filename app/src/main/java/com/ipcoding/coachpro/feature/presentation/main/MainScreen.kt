package com.ipcoding.coachpro.feature.presentation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.feature.presentation.main.components.ClubName

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    Column() {
        ClubName(
            name = viewModel.clubName.value,
            colorBackground = viewModel.colorJersey.value,
            colorText = viewModel.colorStripes.value
        )
    }
}