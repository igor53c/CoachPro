package com.ipcoding.coachpro.feature.presentation.tactics.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
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
fun RatingText(
    title: String,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    Text(
        text = title,
        style = MaterialTheme.typography.h5,
        color = MaterialTheme.colors.primary,
        modifier = modifier
            .padding(bottom = spacing.spaceSmall)
            .fillMaxWidth()
            .border(
                border = BorderStroke(
                    width = spacing.spaceSuperSmall,
                    color = MaterialTheme.colors.primary
                ),
                shape = RoundedCornerShape(corner = CornerSize(spacing.spaceSmall))
            )
            .padding(spacing.spaceSmall),
        textAlign = TextAlign.Center
    )
}