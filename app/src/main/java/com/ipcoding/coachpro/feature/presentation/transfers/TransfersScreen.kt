package com.ipcoding.coachpro.feature.presentation.transfers

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.presentation.players.components.ButtonBack
import com.ipcoding.coachpro.feature.presentation.transfers.components.OneTransferPlayer
import com.ipcoding.coachpro.feature.presentation.transfers.components.TitleRow
import com.ipcoding.coachpro.feature.presentation.transfers.components.TransferConfirmation
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun TransfersScreen(
    navController: NavController,
    viewModel: TransfersViewModel = hiltViewModel()
) {
    val players = viewModel.players.value
    val numberOfPlayers = viewModel.numberOfPlayers.value
    val openDialog = remember { mutableStateOf(false)  }
    val selectedPlayer = remember {
        mutableStateOf(Player("", "", 0.0, 0, 0))
    }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = AppTheme.dimensions.spaceSmall,
                bottom = AppTheme.dimensions.spaceSmall
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleRow()

        Divider(
            color = AppTheme.colors.primary,
            thickness = AppTheme.dimensions.spaceSuperSmall
        )

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(players.size) { item ->
                val player = players[item]
                OneTransferPlayer(
                    player = player,
                    color = viewModel.getColor(player.position),
                    onClick = {
                        openDialog.value = true
                        selectedPlayer.value = player
                    }
                )
                Divider(
                    color = AppTheme.colors.primary,
                    thickness = AppTheme.dimensions.spaceSuperSmall
                )
            }
        }

        if (openDialog.value) {
            val budget = viewModel.getBudget()
            TransferConfirmation(
                budget = budget,
                player = selectedPlayer.value,
                color = viewModel.getColor(selectedPlayer.value.position),
                onCancelClick = { openDialog.value = false },
                onBuyClick = {
                    selectedPlayer.value.transferPlayer = false
                    selectedPlayer.value.number = numberOfPlayers
                    viewModel.saveBudget(budget - selectedPlayer.value.value.toFloat())
                    viewModel.updatePlayer(selectedPlayer.value)
                    openDialog.value = false
                }
            )
        }

        Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceSmall))

        ButtonBack(
            navController = navController,
            modifier = Modifier
                .height(AppTheme.dimensions.spaceLarge)
                .fillMaxWidth()
                .padding(
                    start = AppTheme.dimensions.spaceSmall,
                    end = AppTheme.dimensions.spaceSmall
                )
        )
    }
}