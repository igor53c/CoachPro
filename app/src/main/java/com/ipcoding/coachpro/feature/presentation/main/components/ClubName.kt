package com.ipcoding.coachpro.feature.presentation.main.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ipcoding.coachpro.ui.theme.LocalSpacing

@Composable
fun ClubName(
    name: String,
    colorBackground: Color,
    colorText: Color
) {
    val spacing = LocalSpacing.current
    Text(
        text = name,
        color = colorText,
        style = MaterialTheme.typography.h6,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(spacing.spaceMedium)
            .border(
                border = BorderStroke(
                    width = spacing.spaceSuperSmall,
                    color = MaterialTheme.colors.onBackground
                ),
                shape = RoundedCornerShape(corner = CornerSize(spacing.spaceSmall))
            )
            .background(
                color = colorBackground,
                shape = RoundedCornerShape(corner = CornerSize(spacing.spaceSmall))
            )
            .padding(16.dp)
    )
}