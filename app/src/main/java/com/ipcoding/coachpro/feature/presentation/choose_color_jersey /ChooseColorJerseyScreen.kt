package com.ipcoding.coachpro.feature.presentation.choose_color_jersey

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.choose_color_jersey.components.ColorPicker
import com.ipcoding.coachpro.feature.presentation.choose_color_jersey.components.Jersey
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.LocalSpacing

@Composable
fun ChooseColorJerseyScreen (
    navController: NavController,
    viewModel: ChooseColorJerseyViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val colorJersey = viewModel.colorJersey.value
    val colorStripes = viewModel.colorStripes.value
    
    Scaffold (
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(
                        Screen.MainScreen.route
                    )
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "confirm"
                )
            }
        }
    ){
        Column(
            modifier = Modifier
                .padding(spacing.spaceSmall)
                .fillMaxSize()
        ) {
            Text(
                text = stringResource(id = R.string.select_color_jersey),
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(spacing.spaceMedium)
            )
            ColorPicker(onColorSelected = { color ->
                viewModel.saveColorJersey(color)
            })
            Text(
                text = stringResource(id = R.string.select_color_stripes),
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(spacing.spaceMedium)
            )
            ColorPicker(onColorSelected = { color ->
                viewModel.saveColorStripes(color)
            })
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Jersey(
                colorJersey = colorJersey,
                colorStripes = colorStripes,
                colorBorder = MaterialTheme.colors.onBackground,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}