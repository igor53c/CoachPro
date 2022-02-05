package com.ipcoding.coachpro.feature.presentation.select_league.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.coachpro.ui.theme.LocalSpacing

@Composable
fun Item(
    modifier: Modifier = Modifier,
    title: String
) {
    val spacing = LocalSpacing.current
    Box(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.primary,
            modifier = Modifier
                .border(
                    border = BorderStroke(
                        width = spacing.spaceSuperSmall,
                        color = MaterialTheme.colors.primary
                    ),
                    shape = RoundedCornerShape(corner = CornerSize(spacing.spaceSmall))
                )
                .padding(spacing.spaceMedium)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}