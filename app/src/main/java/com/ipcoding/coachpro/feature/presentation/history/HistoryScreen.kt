package com.ipcoding.coachpro.feature.presentation.history

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.history.components.ItemHistory
import com.ipcoding.coachpro.feature.presentation.table.components.CustomText
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun HistoryScreen(
    viewModel: HistoryViewModel = hiltViewModel()
) {
    val history = viewModel.history.value

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = AppTheme.dimensions.spaceSmall),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = AppTheme.dimensions.spaceSmall,
                    end = AppTheme.dimensions.spaceSmall
                )
                .fillMaxWidth()
        ) {
            CustomText(
                text = stringResource(id = R.string.year),
                textAlign = TextAlign.Center,
                style = AppTheme.typography.body2,
                modifier = Modifier
                    .weight(1f)
            )

            CustomText(
                text = stringResource(id = R.string.league),
                style = AppTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(1f)
            )
            CustomText(
                text = stringResource(id = R.string.position),
                style = AppTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(1f)
            )
        }
        Divider(
            color = AppTheme.colors.primary,
            thickness = AppTheme.dimensions.spaceSuperSmall
        )
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(history.size) { item ->
                ItemHistory(history = history[item])
                Divider(
                    color = AppTheme.colors.primary,
                    thickness = AppTheme.dimensions.spaceSuperSmall
                )
            }
        }

        Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceSmall))
    }
}