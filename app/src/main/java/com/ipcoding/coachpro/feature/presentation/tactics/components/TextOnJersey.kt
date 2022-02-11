package com.ipcoding.coachpro.feature.presentation.tactics.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun TextOnJersey(
    text: String,
    progress: Float = -1f,
    maxWidth: Dp = AppTheme.dimensions.default
) {
    Row(
        modifier = Modifier
            .padding(AppTheme.dimensions.spaceSuperSmall),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            style = AppTheme.typography.overline,
            color = AppTheme.colors.primary,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        if(progress != -1f) {
            Spacer(modifier = Modifier.width(AppTheme.dimensions.spaceSuperSmall))
            LinearProgressIndicator(
                modifier = Modifier.width(maxWidth / 12f),
                backgroundColor = Color.LightGray,
                color = AppTheme.colors.primary,
                progress = progress
            )
        }
    }
}