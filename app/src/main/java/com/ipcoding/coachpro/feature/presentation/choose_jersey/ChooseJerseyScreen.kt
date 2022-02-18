package com.ipcoding.coachpro.feature.presentation.choose_jersey

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.domain.util.JerseyColors
import com.ipcoding.coachpro.feature.presentation.choose_jersey.components.ColorPicker
import com.ipcoding.coachpro.feature.presentation.choose_jersey.components.jersey.Jersey
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun ChooseJerseyScreen (
    navController: NavController,
    viewModel: ChooseJerseyViewModel = hiltViewModel()
) {
    val colorJersey = viewModel.colorJersey.value
    val colorStripes = viewModel.colorStripes.value
    val maxWidth = remember { mutableStateOf(0.dp) }

    Column(
        modifier = Modifier
            .padding(AppTheme.dimensions.spaceSmall)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.select_color_jersey),
            color = AppTheme.colors.primary,
            style = AppTheme.typography.h6,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppTheme.dimensions.spaceMedium)
        )
        ColorPicker(onColorSelected = { color ->
            viewModel.saveColorJersey(color)
        })
        Text(
            text = stringResource(id = R.string.select_color_stripes),
            color = AppTheme.colors.primary,
            style = AppTheme.typography.h6,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppTheme.dimensions.spaceMedium)
        )
        ColorPicker(onColorSelected = { color ->
            viewModel.saveColorStripes(color)
        })
        Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceMedium))
        BoxWithConstraints(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = AppTheme.dimensions.spaceSmall)
        ) {
            if(this.maxHeight / this.maxWidth < 1.2)
                maxWidth.value = this.maxHeight / 1.2f else maxWidth.value = this.maxWidth

            val width = this.maxWidth

            LazyRow(horizontalArrangement = Arrangement.Center) {
                items(6) { item ->

                    Box(
                        modifier = Modifier
                            .width(width)
                            .padding(AppTheme.dimensions.spaceSmall),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .clickable {
                                    viewModel.saveNumberJersey(item + 1)
                                    navController.navigate(Screen.MainScreen.route)
                                }
                                .width(maxWidth.value),
                        ) {
                            Jersey(
                                jerseyColors = JerseyColors(
                                    colorJersey = colorJersey,
                                    colorStripes = colorStripes,
                                    colorBorder = AppTheme.colors.onBackground,
                                ),
                                numberJersey = item + 1
                            )
                        }
                    }
                }
            }
        }
    }
}