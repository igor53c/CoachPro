package com.ipcoding.coachpro.feature.presentation.main.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun DateText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = AppTheme.colors.primary,
        style = AppTheme.typography.subtitle1,
        modifier = modifier,
        textAlign = TextAlign.Center
    )
}