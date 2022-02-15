package com.ipcoding.coachpro.feature.presentation.history.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.coachpro.feature.domain.model.History
import com.ipcoding.coachpro.feature.presentation.table.components.CustomText
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun ItemHistory(
    history: History
) {
    Row(
        modifier = Modifier
            .padding(
                start = AppTheme.dimensions.spaceSmall,
                end = AppTheme.dimensions.spaceSmall
            )
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomText(
            text = history.year.toString(),
            textAlign = TextAlign.Center,
            style = AppTheme.typography.body2,
            modifier = Modifier
                .weight(1f)
        )
        CustomText(
            text = history.league,
            textAlign = TextAlign.Center,
            style = AppTheme.typography.body2,
            modifier = Modifier
                .weight(1f)
        )
        CustomText(
            text = history.position.toString(),
            textAlign = TextAlign.Center,
            style = AppTheme.typography.body2,
            modifier = Modifier
                .weight(1f)
        )
    }
}