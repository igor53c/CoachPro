package com.ipcoding.coachpro.feature.presentation.schedule

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.coachpro.feature.presentation.players.components.ButtonBack
import com.ipcoding.coachpro.feature.presentation.schedule.components.OneMatch
import com.ipcoding.coachpro.feature.presentation.select_league.components.Item
import com.ipcoding.coachpro.ui.theme.AppTheme
import kotlinx.coroutines.launch

@Composable
fun ScheduleScreen(
    navController: NavController,
    roundNumber: Int,
    viewModel: ScheduleViewModel = hiltViewModel()
) {
    val maxWidth = remember { mutableStateOf(0.dp) }
    val matches = viewModel.matches.value
    val clubName = viewModel.clubName.value
    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(AppTheme.dimensions.spaceSmall)
    ) {
        Item(title = viewModel.getStringLeague())
        Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceMedium))
        BoxWithConstraints(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = AppTheme.dimensions.spaceSmall)
        ) {
            maxWidth.value = this.maxWidth

            coroutineScope.launch {
                listState.scrollToItem(roundNumber - 1)
            }

            LazyRow(
                verticalAlignment = Alignment.Top,
                modifier = Modifier,
                state = listState
            ) {
                items(38) { item1 ->
                    Column(
                        modifier = Modifier
                            .width(maxWidth.value)
                    ) {
                        Item(
                            title = "Round ${item1 + 1}",
                            colorText = AppTheme.colors.background,
                            colorBackground = AppTheme.colors.primary,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceSmall))

                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    top = AppTheme.dimensions.spaceSmall,
                                    bottom = AppTheme.dimensions.spaceSmall
                                )
                        ) {
                            items(10) { item2 ->
                                if(matches.isNotEmpty()) {
                                    val match = matches[item1 * 10 + item2]
                                    OneMatch(
                                        match = match,
                                        clubName = clubName
                                    )
                                }
                            }
                        }
                    }
                    if(item1 != 37)
                        Spacer(modifier = Modifier.width(AppTheme.dimensions.spaceExtraMedium))
                }
            }
        }
        ButtonBack(
            navController = navController,
            modifier = Modifier
                .height(AppTheme.dimensions.spaceLarge)
                .fillMaxWidth(),
        )
    }
}