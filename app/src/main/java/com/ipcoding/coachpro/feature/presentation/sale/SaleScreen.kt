package com.ipcoding.coachpro.feature.presentation.sale

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.select_club.components.CustomButton
import com.ipcoding.coachpro.feature.presentation.table.components.CustomText
import com.ipcoding.coachpro.feature.presentation.transfers.components.TransferConfirmationRow
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun SaleScreen(
    navController: NavController,
    viewModel: SaleViewModel = hiltViewModel()
) {
    val player = viewModel.player.value

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(AppTheme.dimensions.spaceSmall)
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomText(
                    text = player.name,
                    style = AppTheme.typography.h5,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(bottom = AppTheme.dimensions.spaceMedium)
                        .fillMaxWidth()
                )
                TransferConfirmationRow(
                    textPosition = stringResource(id = R.string.pos),
                    textRating = stringResource(id = R.string.rating),
                    textAge = stringResource(id = R.string.age),
                    textValue = stringResource(id = R.string.meuro)
                )
                TransferConfirmationRow(
                    textPosition = player.position,
                    textRating = String.format("%.1f", player.rating),
                    textAge = player.age.toString(),
                    textValue = String.format("%.1f", player.value),
                    backgroundColor = viewModel.getColor(player.position)
                )
            }
            CustomText(
                text = stringResource(id = R.string.offer_arrived),
                style = AppTheme.typography.h6,
                maxLines = 3,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            CustomText(
                text = viewModel.valueString(player.value.toFloat()),
                style = AppTheme.typography.h2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = AppTheme.dimensions.spaceMedium)
                    .fillMaxWidth()
                    .weight(1f)
            )
        }
        Row(
            modifier = Modifier
                .height(AppTheme.dimensions.spaceLarge)
                .fillMaxWidth(),
        ) {

            CustomButton(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                onClick = {
                    viewModel.deletePlayer(player)
                    viewModel.saveBudget(player.value.toFloat())
                    navController.navigate(Screen.MainScreen.route)
                },
                shape = AppTheme.customShapes.rectangleShape
            ) {
                Text(
                    text = stringResource(id = R.string.sell),
                    style = AppTheme.typography.body1
                )
            }

            CustomButton(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                onClick = {
                    navController.navigate(Screen.MainScreen.route)
                },
                shape = AppTheme.customShapes.rectangleShape
            ) {
                Text(
                    text = stringResource(id = R.string.reject),
                    style = AppTheme.typography.body1
                )
            }
        }
    }
}
