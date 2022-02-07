package com.ipcoding.coachpro.feature.presentation.players.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.select_club.components.CustomButton
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun ButtonBack(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    CustomButton(
        modifier = modifier,
        onClick = {
            navController.navigate(
                Screen.MainScreen.route
            )
        }
    ) {
        Text(
            text = stringResource(id = R.string.back),
            style = AppTheme.typography.body1
        )
    }
}
