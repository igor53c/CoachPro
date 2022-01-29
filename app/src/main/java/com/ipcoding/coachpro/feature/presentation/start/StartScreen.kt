package com.ipcoding.coachpro.feature.presentation.start

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun StartScreen (
    navController: NavController,
    viewModel: StartViewModel = hiltViewModel()
) {
    Text(text = "Hello ${viewModel.loadClubName()}!")
}