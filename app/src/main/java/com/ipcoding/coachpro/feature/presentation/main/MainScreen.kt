package com.ipcoding.coachpro.feature.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.core.util.TestTags
import com.ipcoding.coachpro.feature.domain.util.WeekType
import com.ipcoding.coachpro.feature.presentation.main.components.*
import com.ipcoding.coachpro.feature.presentation.select_club.components.CustomButton
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val colorText = viewModel.colorText.value
    val formMatches = viewModel.formMatches.value
    val colorBackground = viewModel.colorJersey.value
    val info = viewModel.info.value
    val openDialog = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .padding(bottom = AppTheme.dimensions.spaceSmall)
                    .fillMaxWidth()
                    .height(AppTheme.dimensions.spaceExtraLarge)
                    .background(AppTheme.colors.primary),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    color = AppTheme.colors.background,
                    style = AppTheme.typography.h5,
                    textAlign = TextAlign.Center
                )
                IconButton(
                    onClick = {
                        openDialog.value = true
                    },
                    modifier = Modifier
                        .fillMaxHeight()
                        .align(alignment = Alignment.CenterEnd)
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "NewGame",
                        tint = AppTheme.colors.background
                    )
                }
            }

            DateRow(viewModel = viewModel)

            ClubName(
                name = viewModel.clubName.value,
                colorBackground = colorBackground,
                colorText = colorText
            )

            CentralPart(
                viewModel = viewModel,
                navController = navController,
                colorBackground = colorBackground,
                colorText = colorText
            )

            Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceMedium))

            FormMatches(formMatches)
        }
        CustomButton(
            modifier = Modifier
                .height(AppTheme.dimensions.spaceLarge)
                .fillMaxWidth()
                .testTag(TestTags.BUTTON_CONFIRM_MAINSCREEN),
            onClick = {
                viewModel.saveWeekYear()
                navController.navigate(Screen.InfoScreen.route)
            },
            shape = AppTheme.customShapes.rectangleShape
        ) {
            info?.let { weekType ->
                when (weekType) {
                    is WeekType.Schedule ->
                        weekType.text = stringResource(id = R.string.next_week)
                    is WeekType.Transfers ->
                        weekType.text = stringResource(id = R.string.transfers)
                    is WeekType.Tactics ->
                        weekType.text = stringResource(id = R.string.match)
                    is WeekType.Else ->
                        weekType.text = stringResource(id = R.string.next_week)
                }
                Text(
                    text = weekType.text,
                    style = AppTheme.typography.body1
                )
            }
        }
    }

    if (openDialog.value) {
        NewGame(
            onNoClick = {
                openDialog.value = false
            },
            onYesClick = {
                navController.navigate(Screen.SelectLeagueScreen.route)
                openDialog.value = false
            }
        )
    }
}