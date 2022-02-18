package com.ipcoding.coachpro.feature.presentation.result

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.result.components.OneBox
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.AppTheme
import kotlinx.coroutines.delay

@Composable
fun ResultScreen(
    navController: NavController,
    viewModel: ResultViewModel = hiltViewModel()
) {
    val animationPlayed = remember { mutableStateOf(false) }
    val match = viewModel.match.value
    val roundNumber = viewModel.roundNumber.value
    val goalsHost = remember { mutableStateOf("") }
    val goalsGuest = remember { mutableStateOf("") }

    if (match?.goalsHost != -1) goalsHost.value = match?.goalsHost.toString()
    if (match?.goalsGuest != -1) goalsGuest.value = match?.goalsGuest.toString()

    val time = animateIntAsState(
        targetValue = if (animationPlayed.value) 24 else 0,
        animationSpec = tween(
            durationMillis = 6000,
            delayMillis = 0
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = AppTheme.dimensions.spaceLarge,
                bottom = AppTheme.dimensions.spaceLarge,
                start = AppTheme.dimensions.spaceSmall,
                end = AppTheme.dimensions.spaceSmall,
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OneBox(
            modifier = Modifier.weight(1f),
            showText = time.value > 7,
            text = "${match?.host}",
            style = AppTheme.typography.h4
        )
        OneBox(
            modifier = Modifier.weight(1f),
            showText = time.value > 17,
            text = goalsHost.value,
            style = AppTheme.typography.h1
        )
        OneBox(
            modifier = Modifier.weight(1f),
            showText = time.value > 2,
            text = stringResource(id = R.string.vs),
            style = AppTheme.typography.h3
        )
        OneBox(
            modifier = Modifier.weight(1f),
            showText = time.value > 22,
            text = goalsGuest.value,
            style = AppTheme.typography.h1
        )
        OneBox(
            modifier = Modifier.weight(1f),
            showText = time.value > 12,
            text = "${match?.guest}",
            style = AppTheme.typography.h4
        )
    }

    LaunchedEffect(key1 = true) {
        animationPlayed.value = true
        delay(6000L)
        navController.navigate(Screen.ScheduleScreen.route + "?roundNumber=$roundNumber")
    }
}