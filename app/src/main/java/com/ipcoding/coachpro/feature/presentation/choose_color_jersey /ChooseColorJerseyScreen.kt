package com.ipcoding.coachpro.feature.presentation.choose_color_jersey

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun ChooseColorJerseyScreen (
    navController: NavController,
    viewModel: ChooseColorJerseyViewModel = hiltViewModel()
) {
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
                .padding(AppTheme.dimens.spaceSmall)
                .fillMaxSize()
        ) {
            Text(
                text = stringResource(id = R.string.select_color_jersey),
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(AppTheme.dimens.spaceMedium)
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
                    .padding(AppTheme.dimens.spaceMedium)
            )
            ColorPicker(onColorSelected = { color ->
                viewModel.saveColorStripes(color)
            })
            Spacer(modifier = Modifier.height(AppTheme.dimens.spaceMedium))
            BoxWithConstraints(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = AppTheme.dimens.spaceSmall)
            ) {
                Box(modifier = Modifier.height(this.maxWidth * 1.2f)) {
                    Jersey(
                        colorJersey = colorJersey,
                        colorStripes = colorStripes,
                        colorBorder = MaterialTheme.colors.onBackground,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}