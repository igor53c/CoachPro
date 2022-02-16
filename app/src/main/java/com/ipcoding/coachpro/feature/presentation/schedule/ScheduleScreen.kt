package com.ipcoding.coachpro.feature.presentation.schedule

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ipcoding.coachpro.core.util.TestTags
import com.ipcoding.coachpro.feature.presentation.schedule.components.OneMatch
import com.ipcoding.coachpro.feature.presentation.select_league.components.Item
import com.ipcoding.coachpro.ui.theme.AppTheme
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ScheduleScreen(
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
    ) {
        Text(
            text = viewModel.getStringLeague(),
            style = AppTheme.typography.h6,
            color =AppTheme.colors.primary,
            modifier = Modifier
                .padding(AppTheme.dimensions.spaceMedium)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Divider(
            color = AppTheme.colors.primary,
            thickness = AppTheme.dimensions.spaceSuperSmall
        )

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
                modifier = Modifier
                    .testTag(TestTags.LAZY_ROW_SCHEDULESCREEN),
                state = listState
            ) {
                items(38) { item1 ->
                    Column(
                        modifier = Modifier
                            .width(maxWidth.value)
                    ) {
                        Item(
                            title = "Round ${item1 + 1}",
                            colorText = AppTheme.colors.primary,
                            colorBackground = AppTheme.colors.background,
                            modifier = Modifier
                                .padding(
                                   start = AppTheme.dimensions.spaceSmall,
                                   end = AppTheme.dimensions.spaceSmall
                                )
                                .fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceSmall))

                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(AppTheme.dimensions.spaceSmall)
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
    }
}