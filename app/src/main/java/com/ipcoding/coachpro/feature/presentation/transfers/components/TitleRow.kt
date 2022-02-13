package com.ipcoding.coachpro.feature.presentation.transfers.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.table.components.CustomText
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun TitleRow() {
    Row(
        modifier = Modifier
            .padding(
                start = AppTheme.dimensions.spaceSmall,
                end = AppTheme.dimensions.spaceSmall
            )
            .fillMaxWidth()
    ) {
        CustomText(
            text = stringResource(id = R.string.name),
            textAlign = TextAlign.Start,
            style = AppTheme.typography.body2,
            modifier = Modifier
                .weight(1f)
        )
        CustomText(
            text = stringResource(id = R.string.pos),
            style = AppTheme.typography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(AppTheme.dimensions.spaceExtraLarge)
        )
        CustomText(
            text = stringResource(id = R.string.rating),
            style = AppTheme.typography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(AppTheme.dimensions.spaceExtraLarge)
        )
        CustomText(
            text = stringResource(id = R.string.age),
            style = AppTheme.typography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(AppTheme.dimensions.spaceLarge)
        )
        CustomText(
            text = stringResource(id = R.string.meuro),
            style = AppTheme.typography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(AppTheme.dimensions.spaceExtraLarge)
        )
    }
}