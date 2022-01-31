package com.ipcoding.coachpro.feature.presentation.choose_color_jersey

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.feature.presentation.choose_color_jersey.components.ColorPicker
import com.ipcoding.coachpro.feature.presentation.choose_color_jersey.components.Jersey

@Composable
fun ChooseColorJerseyScreen (
    navController: NavController,
    viewModel: ChooseColorJerseyViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        ColorPicker(onColorSelected = {})
        Jersey()
    }
}