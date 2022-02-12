package com.ipcoding.coachpro.feature.presentation.transfers

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.select_club.components.CustomButton
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun TransfersScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .padding(AppTheme.dimensions.spaceSmall)
            .fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.weight(1f)
        ) {

        }
        CustomButton(
            modifier = Modifier
                .height(AppTheme.dimensions.spaceLarge)
                .fillMaxWidth(),
            onClick = {
                navController.navigate(Screen.MainScreen.route)
            }
        ) {
            Text(
                text = stringResource(id = R.string.confirm),
                style = AppTheme.typography.body1
            )
        }
    }
}