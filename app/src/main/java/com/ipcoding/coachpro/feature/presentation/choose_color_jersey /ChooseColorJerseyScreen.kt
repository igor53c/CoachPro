package com.ipcoding.coachpro.feature.presentation.choose_color_jersey

import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.choose_color_jersey.components.ColorPicker
import com.ipcoding.coachpro.feature.presentation.choose_color_jersey.components.Jersey
import com.ipcoding.coachpro.feature.presentation.players.components.ButtonBack
import com.ipcoding.coachpro.feature.presentation.select_club.components.CustomButton
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun ChooseColorJerseyScreen (
    navController: NavController,
    viewModel: ChooseColorJerseyViewModel = hiltViewModel()
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
            color = AppTheme.colors.secondaryVariant,
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
            color = AppTheme.colors.secondaryVariant,
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
            Box(
                contentAlignment = Alignment.TopCenter,
                modifier = Modifier.fillMaxSize()
            ) {
                Jersey(
                    colorJersey = colorJersey,
                    colorStripes = colorStripes,
                    colorBorder = AppTheme.colors.onBackground,
                    modifier = Modifier
                        .width( maxWidth.value)
                )
            }
        }
        CustomButton(
            onClick = { navController.navigate(Screen.MainScreen.route) },
            modifier = Modifier
                .height(AppTheme.dimensions.spaceLarge)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.confirm),
                color = AppTheme.colors.onPrimary,
                style = AppTheme.typography.body1,
            )
        }
    }
}