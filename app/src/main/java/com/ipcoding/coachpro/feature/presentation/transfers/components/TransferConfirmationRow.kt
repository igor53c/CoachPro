package com.ipcoding.coachpro.feature.presentation.transfers.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.coachpro.feature.presentation.table.components.CustomText
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun TransferConfirmationRow(
    textPosition: String,
    textRating: String,
    textAge: String,
    textValue: String,
    color: Color = Color.Transparent
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
            text = textPosition,
            style = AppTheme.typography.body2,
            backgroundColor = color,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
        )
        CustomText(
            text = textRating,
            style = AppTheme.typography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
        )
        CustomText(
            text = textAge,
            style = AppTheme.typography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
        )
        CustomText(
            text = textValue,
            style = AppTheme.typography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
        )
    }
}