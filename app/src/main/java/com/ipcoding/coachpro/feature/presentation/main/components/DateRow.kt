package com.ipcoding.coachpro.feature.presentation.main.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.main.MainViewModel
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun DateRow(
    viewModel: MainViewModel
) {
    val year =  viewModel.year.value
    val week =  viewModel.week.value
    val month =  viewModel.month.value

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = AppTheme.dimensions.spaceExtraMedium)
    ) {
        DateText(
            text = month,
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(AppTheme.dimensions.spaceMedium))

        DateText(
            text = year.toString(),
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(AppTheme.dimensions.spaceMedium))

        DateText(
            text = stringResource(id = R.string.week) + " $week",
            modifier = Modifier.weight(1f)
        )
    }
}